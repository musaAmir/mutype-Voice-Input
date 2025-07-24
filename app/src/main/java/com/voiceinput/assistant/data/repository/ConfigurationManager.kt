package com.voiceinput.assistant.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.voiceinput.assistant.data.model.AIModel
import com.voiceinput.assistant.data.model.VoiceInputConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConfigurationManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences(
        "voice_input_config", 
        Context.MODE_PRIVATE
    )
    
    companion object {
        private const val KEY_CONFIG = "current_config"
        private const val KEY_API_KEY = "api_key"
        private const val KEY_MODEL = "selected_model"
        private const val KEY_LANGUAGE = "selected_language"
        private const val KEY_TEMPERATURE = "temperature"
        private const val KEY_AUTO_START_RECORDING = "auto_start_recording"
        private const val KEY_TRANSCRIPTION_DELAY = "transcription_delay"
        private const val KEY_APP_THEME = "app_theme"
        private const val KEY_FLOATING_BUTTON_ENABLED = "floating_button_enabled"
    }
    
    enum class AppTheme {
        DARK_BLUE,    // Current theme
        AMOLED_BLACK, // Pure black for AMOLED
        DARK_GRAY     // Regular dark theme
    }
    
    fun saveConfiguration(config: VoiceInputConfig) {
        prefs.edit().apply {
            putString(KEY_CONFIG, gson.toJson(config))
            putString(KEY_API_KEY, config.apiKey)
            putString(KEY_MODEL, config.model.id)
            putString(KEY_LANGUAGE, config.language)
            putFloat(KEY_TEMPERATURE, config.temperature)
            apply()
        }
    }
    
    fun getCurrentConfig(): VoiceInputConfig? {
        val configJson = prefs.getString(KEY_CONFIG, null)
        return if (configJson != null) {
            try {
                gson.fromJson(configJson, VoiceInputConfig::class.java)
            } catch (e: Exception) {
                // Return default config if parsing fails
                getDefaultConfig()
            }
        } else {
            // Return default config if no config exists
            getDefaultConfig()
        }
    }
    
    private fun getDefaultConfig(): VoiceInputConfig {
        return VoiceInputConfig(
            apiKey = getApiKey(),
            model = getSelectedModel(),
            language = getSelectedLanguage(),
            temperature = getTemperature()
        )
    }
    
    fun getApiKey(): String = prefs.getString(KEY_API_KEY, "") ?: ""
    
    fun getSelectedModel(): AIModel {
        val modelId = prefs.getString(KEY_MODEL, AIModel.GROQ_WHISPER_LARGE_V3_TURBO.id) ?: AIModel.GROQ_WHISPER_LARGE_V3_TURBO.id
        return AIModel.values().find { it.id == modelId } ?: AIModel.GROQ_WHISPER_LARGE_V3_TURBO
    }
    
    fun getSelectedLanguage(): String = prefs.getString(KEY_LANGUAGE, "auto") ?: "auto"
    
    fun getTemperature(): Float = prefs.getFloat(KEY_TEMPERATURE, 0.3f)
    
    fun getAutoStartRecording(): Boolean = prefs.getBoolean(KEY_AUTO_START_RECORDING, false)
    
    fun setAutoStartRecording(autoStart: Boolean) {
        prefs.edit().putBoolean(KEY_AUTO_START_RECORDING, autoStart).apply()
    }
    
    fun getTranscriptionDelay(): Int = prefs.getInt(KEY_TRANSCRIPTION_DELAY, 2000) // Default 2 seconds
    
    fun setTranscriptionDelay(delayMs: Int) {
        prefs.edit().putInt(KEY_TRANSCRIPTION_DELAY, delayMs).apply()
    }
    
    fun getAppTheme(): AppTheme {
        val themeName = prefs.getString(KEY_APP_THEME, AppTheme.DARK_GRAY.name) // CHANGED: Default to DARK_GRAY instead of DARK_BLUE
        return try {
            AppTheme.valueOf(themeName ?: AppTheme.DARK_GRAY.name)
        } catch (e: IllegalArgumentException) {
            AppTheme.DARK_GRAY // CHANGED: Fallback to DARK_GRAY instead of DARK_BLUE
        }
    }
    
    fun setAppTheme(theme: AppTheme) {
        prefs.edit().putString(KEY_APP_THEME, theme.name).apply()
    }
    
    fun getFloatingButtonEnabled(): Boolean = prefs.getBoolean(KEY_FLOATING_BUTTON_ENABLED, false)
    
    fun setFloatingButtonEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_FLOATING_BUTTON_ENABLED, enabled).apply()
    }
    
    fun isConfigured(): Boolean = getCurrentConfig() != null && getApiKey().isNotEmpty()
    
    fun clearConfiguration() {
        prefs.edit().clear().apply()
    }
}