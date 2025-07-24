package com.voiceinput.assistant.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.*
import java.io.File
import android.util.Base64

interface GeminiApiService {

    @POST("v1/speech:recognize")
    suspend fun transcribeWithGemini(
        @Header("X-Goog-Api-Key") apiKey: String,
        @Body request: GeminiSpeechRequest
    ): GeminiTranscriptionResponse

}

data class GeminiSpeechRequest(
    val config: GeminiRecognitionConfig,
    val audio: GeminiAudioContent
)

data class GeminiRecognitionConfig(
    val encoding: String = "WEBM_OPUS", // or "LINEAR16" for WAV
    val sampleRateHertz: Int = 16000,
    val languageCode: String = "en-US",
    val enableAutomaticPunctuation: Boolean = true,
    val model: String = "latest_long"
)

data class GeminiAudioContent(
    val content: String // Base64 encoded audio
)

data class GeminiTranscriptionResponse(
    val results: List<GeminiResult>
)

data class GeminiResult(
    val alternatives: List<GeminiAlternative>
)

data class GeminiAlternative(
    val transcript: String,
    val confidence: Float = 1.0f
)

object GeminiApiClient {
    fun createRequest(audioFile: File, languageCode: String = "en-US"): GeminiSpeechRequest {
        val audioBytes = audioFile.readBytes()
        val base64Audio = Base64.encodeToString(audioBytes, Base64.NO_WRAP)
        
        return GeminiSpeechRequest(
            config = GeminiRecognitionConfig(
                encoding = "LINEAR16", // WAV format
                sampleRateHertz = 16000,
                languageCode = languageCode,
                enableAutomaticPunctuation = true,
                model = "latest_long"
            ),
            audio = GeminiAudioContent(content = base64Audio)
        )
    }
    
    fun getLanguageCode(language: String): String {
        return when (language.lowercase()) {
            "auto" -> "en-US" // Default to English for auto-detect
            "english" -> "en-US"
            "spanish" -> "es-ES"
            "french" -> "fr-FR"
            "german" -> "de-DE"
            "italian" -> "it-IT"
            "portuguese" -> "pt-PT"
            "russian" -> "ru-RU"
            "japanese" -> "ja-JP"
            "korean" -> "ko-KR"
            "chinese (mandarin)" -> "zh-CN"
            "arabic" -> "ar-SA"
            "hindi" -> "hi-IN"
            else -> "en-US"
        }
    }
}