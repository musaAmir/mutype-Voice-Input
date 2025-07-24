package com.voiceinput.assistant.data.repository

import com.voiceinput.assistant.data.audio.AudioRecorder
import com.voiceinput.assistant.data.model.AIModel
import com.voiceinput.assistant.data.model.TranscriptionResult
import com.voiceinput.assistant.data.model.VoiceInputConfig
import com.voiceinput.assistant.data.network.OpenAIApiClient
import com.voiceinput.assistant.data.network.OpenAIApiService
import com.voiceinput.assistant.data.network.GroqApiClient
import com.voiceinput.assistant.data.network.GroqApiService
import com.voiceinput.assistant.data.network.GeminiApiService
import com.voiceinput.assistant.data.network.GeminiApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VoiceInputRepository @Inject constructor(
    private val apiService: OpenAIApiService,
    private val groqApiService: GroqApiService,
    private val geminiApiService: GeminiApiService,
    private val audioRecorder: AudioRecorder,
    private val configManager: ConfigurationManager
) {

    private val _transcriptionState = MutableStateFlow<TranscriptionResult?>(null)
    val transcriptionState: StateFlow<TranscriptionResult?> = _transcriptionState
    private var isRecording = false

    fun startRecording() {
        if (isRecording) return
        
        // Clear any previous state first
        _transcriptionState.value = null
        
        isRecording = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                audioRecorder.startRecording()
            } catch (e: Exception) {
                isRecording = false
                _transcriptionState.value = TranscriptionResult.Error("Failed to start recording: ${e.message}")
            }
        }
    }

    fun stopRecording() {
        if (!isRecording) return
        isRecording = false
        CoroutineScope(Dispatchers.IO).launch {
            _transcriptionState.value = TranscriptionResult.Processing
            try {
                val audioData = audioRecorder.stopRecording()
                if (audioData.isEmpty()) {
                    _transcriptionState.value = TranscriptionResult.Error("No audio data recorded.")
                    return@launch
                }

                val config = configManager.getCurrentConfig()
                if (config == null || config.apiKey.isEmpty()) {
                    _transcriptionState.value = TranscriptionResult.Error("API Key not configured. Please configure in Settings.")
                    return@launch
                }

                // Create temporary file from audio data
                val tempFile = File.createTempFile("audio_", ".wav")
                tempFile.deleteOnExit()
                FileOutputStream(tempFile).use { fos ->
                    fos.write(audioData)
                }

                val result = when (config.model) {
                    AIModel.WHISPER_1,
                    AIModel.GPT_4O_TRANSCRIBE,
                    AIModel.GPT_4O_MINI_TRANSCRIBE -> transcribeWithWhisper(tempFile, config)
                    AIModel.GROQ_WHISPER_LARGE_V3,
                    AIModel.GROQ_WHISPER_LARGE_V3_TURBO -> transcribeWithGroq(tempFile, config)
                    AIModel.GEMINI_SPEECH -> transcribeWithGemini(tempFile, config)
                    else -> TranscriptionResult.Error("Model not supported")
                }
                _transcriptionState.value = result

                // Clean up temp file
                tempFile.delete()
            } catch (e: Exception) {
                _transcriptionState.value = TranscriptionResult.Error("Transcription failed: ${e.message}")
            }
        }
    }

    fun clearTranscription() {
        _transcriptionState.value = null
    }

    fun resetRecordingState() {
        // Ensure clean state for new recording session
        isRecording = false
        _transcriptionState.value = null
    }

    private suspend fun transcribeWithWhisper(
        audioFile: File,
        config: VoiceInputConfig
    ): TranscriptionResult {
        val filePart = OpenAIApiClient.create(audioFile)
        val modelPart = OpenAIApiClient.createPartFromString(config.model.id)
        val languagePart = if (config.language != "auto") OpenAIApiClient.createPartFromString(config.language) else null
        val tempPart = OpenAIApiClient.createPartFromString(config.temperature.toString())

        val response = apiService.transcribeWithWhisper(
            authorization = "Bearer ${config.apiKey}",
            file = filePart,
            model = modelPart,
            language = languagePart,
            temperature = tempPart
        )
        return TranscriptionResult.Success(response.text)
    }

    private suspend fun transcribeWithGroq(
        audioFile: File,
        config: VoiceInputConfig
    ): TranscriptionResult {
        val filePart = GroqApiClient.create(audioFile)
        val modelPart = GroqApiClient.createPartFromString(config.model.id)
        val languagePart = if (config.language != "auto") GroqApiClient.createPartFromString(config.language) else null
        val tempPart = GroqApiClient.createPartFromString(config.temperature.toString())
        val responseFormatPart = GroqApiClient.createPartFromString("json")

        val response = groqApiService.transcribeWithGroqWhisper(
            authorization = "Bearer ${config.apiKey}",
            file = filePart,
            model = modelPart,
            language = languagePart,
            temperature = tempPart,
            responseFormat = responseFormatPart
        )
        return TranscriptionResult.Success(response.text)
    }

    private suspend fun transcribeWithGemini(
        audioFile: File,
        config: VoiceInputConfig
    ): TranscriptionResult {
        return try {
            val languageCode = GeminiApiClient.getLanguageCode(config.language)
            val request = GeminiApiClient.createRequest(audioFile, languageCode)
            
            val response = geminiApiService.transcribeWithGemini(
                apiKey = config.apiKey,
                request = request
            )
            
            val transcript = response.results.firstOrNull()
                ?.alternatives?.firstOrNull()
                ?.transcript ?: ""
                
            TranscriptionResult.Success(transcript)
        } catch (e: Exception) {
            TranscriptionResult.Error("Google Cloud Speech error: ${e.message}")
        }
    }

    suspend fun testConnection(config: VoiceInputConfig): Boolean {
        return try {
            // Simple test - just check if API key is not empty
            // In a real implementation, you might make a test API call
            config.apiKey.isNotEmpty()
        } catch (e: Exception) {
            false
        }
    }
}