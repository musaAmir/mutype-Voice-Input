package com.voiceinput.assistant.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voiceinput.assistant.data.model.AIModel
import com.voiceinput.assistant.data.model.VoiceInputConfig
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.data.repository.VoiceInputRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val configManager: ConfigurationManager,
    private val repository: VoiceInputRepository
) : ViewModel() {
    
    // Available models in order they appear in the UI
    private val availableModels = listOf(
        // Groq Models - Ultra Fast (Recommended)
        AIModel.GROQ_WHISPER_LARGE_V3_TURBO,
        AIModel.GROQ_WHISPER_LARGE_V3,
        // OpenAI Models
        AIModel.GPT_4O_MINI_TRANSCRIBE,
        AIModel.GPT_4O_TRANSCRIBE,
        AIModel.WHISPER_1,
        // Google Cloud Speech
        AIModel.GEMINI_SPEECH
    )
    
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()
    
    private val _events = MutableSharedFlow<Event>()
    val events: SharedFlow<Event> = _events.asSharedFlow()
    
    init {
        loadCurrentSettings()
    }
    
    private fun loadCurrentSettings() {
        val config = configManager.getCurrentConfig()
        val selectedModel = configManager.getSelectedModel()
        
        _uiState.value = _uiState.value.copy(
            selectedModelIndex = availableModels.indexOf(selectedModel).takeIf { it >= 0 } ?: 0,
            apiKey = config?.apiKey ?: "",
            selectedLanguageIndex = getLanguageIndex(configManager.getSelectedLanguage()),
            temperature = configManager.getTemperature(),
            selectedModel = selectedModel
        )
        
        updateModelInfo(selectedModel)
    }
    
    fun onModelSelected(index: Int) {
        if (index >= 0 && index < availableModels.size) {
            val selectedModel = availableModels[index]
            _uiState.value = _uiState.value.copy(
                selectedModelIndex = index,
                selectedModel = selectedModel
            )
            updateModelInfo(selectedModel)
        }
    }
    
    private fun updateModelInfo(model: AIModel) {
        _uiState.value = _uiState.value.copy(
            selectedModelDescription = model.description,
            currentApiKeyLabel = model.apiKeyLabel,
            currentApiKeyHint = model.apiKeyHint,
            currentApiKeyDescription = model.apiKeyDescription
        )
    }
    
    fun getModelDisplayNames(): List<String> {
        return availableModels.map { "${it.displayName} (${it.provider})" }
    }
    
    fun getLanguageDisplayNames(): List<String> {
        return listOf(
            "Auto-detect",
            "English",
            "Spanish", 
            "French",
            "German",
            "Italian",
            "Portuguese",
            "Russian",
            "Japanese",
            "Korean",
            "Chinese"
        )
    }
    
    suspend fun saveSettings(
        selectedModelIndex: Int,
        apiKey: String,
        selectedLanguageIndex: Int,
        temperature: Float
    ) {
        val selectedModel = availableModels[selectedModelIndex]
        val selectedLanguage = getLanguageCode(selectedLanguageIndex)
        
        val config = VoiceInputConfig(
            apiKey = apiKey,
            model = selectedModel,
            language = selectedLanguage,
            temperature = temperature
        )
        
        configManager.saveConfiguration(config)
        
        // Update UI state to reflect saved settings
        _uiState.value = _uiState.value.copy(
            selectedModelIndex = selectedModelIndex,
            apiKey = apiKey,
            selectedLanguageIndex = selectedLanguageIndex,
            temperature = temperature,
            selectedModel = selectedModel
        )
        
        _events.emit(Event.SettingsSaved)
    }
    
    fun updateApiKey(apiKey: String) {
        _uiState.value = _uiState.value.copy(apiKey = apiKey)
    }
    
    suspend fun testConnection() {
        val currentState = _uiState.value
        val config = VoiceInputConfig(
            apiKey = currentState.apiKey,
            model = currentState.selectedModel,
            language = getLanguageCode(currentState.selectedLanguageIndex),
            temperature = currentState.temperature
        )
        
        try {
            val success = repository.testConnection(config)
            if (success) {
                _events.emit(Event.TestConnectionSuccess)
            } else {
                _events.emit(Event.TestConnectionError("Connection test failed"))
            }
        } catch (e: Exception) {
            _events.emit(Event.TestConnectionError(e.message ?: "Unknown error"))
        }
    }
    
    private fun getLanguageIndex(languageCode: String): Int {
        val languages = listOf(
            "auto", "en", "es", "fr", "de", "it", "pt", "ru", "ja", "ko", "zh", "ar", "hi"
        )
        return languages.indexOf(languageCode).takeIf { it >= 0 } ?: 0
    }
    
    private fun getLanguageCode(index: Int): String {
        val languages = listOf(
            "auto", "en", "es", "fr", "de", "it", "pt", "ru", "ja", "ko", "zh", "ar", "hi"
        )
        return languages.getOrElse(index) { "auto" }
    }
    
    sealed class Event {
        object SettingsSaved : Event()
        object TestConnectionSuccess : Event()
        data class TestConnectionError(val message: String) : Event()
    }
}

data class SettingsUiState(
    val selectedModelIndex: Int = 0,
    val selectedLanguageIndex: Int = 0,
    val temperature: Float = 0.3f,
    val apiKey: String = "",
    val selectedModel: AIModel = AIModel.GROQ_WHISPER_LARGE_V3_TURBO,
    val selectedModelDescription: String = AIModel.GROQ_WHISPER_LARGE_V3_TURBO.description,
    val currentApiKeyLabel: String = AIModel.GROQ_WHISPER_LARGE_V3_TURBO.apiKeyLabel,
    val currentApiKeyHint: String = AIModel.GROQ_WHISPER_LARGE_V3_TURBO.apiKeyHint,
    val currentApiKeyDescription: String = AIModel.GROQ_WHISPER_LARGE_V3_TURBO.apiKeyDescription
) {
    val canTestConnection: Boolean
        get() = apiKey.isNotEmpty()
}