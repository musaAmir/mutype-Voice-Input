package com.voiceinput.assistant.data.model

data class VoiceInputConfig(
    val apiKey: String,
    val model: AIModel,
    val language: String = "auto",
    val temperature: Float = 0.3f,
    val maxDuration: Int = 30
)

enum class AIModel(
    val id: String,
    val displayName: String,
    val provider: String,
    val description: String,
    val apiKeyLabel: String,
    val apiKeyHint: String,
    val apiKeyDescription: String,
    val supportsMultipleLanguages: Boolean = true,
    val isRecommended: Boolean = false
) {
    // OpenAI Whisper and Transcription Models
    WHISPER_1(
        id = "whisper-1",
        displayName = "Whisper v1 (Legacy)",
        provider = "OpenAI",
        description = "Original Whisper model. Supports 99+ languages with good accuracy. Legacy model.",
        apiKeyLabel = "OpenAI API Key",
        apiKeyHint = "sk-...",
        apiKeyDescription = "Get your API key from https://platform.openai.com/api-keys",
        isRecommended = false
    ),
    GPT_4O_TRANSCRIBE(
        id = "gpt-4o-transcribe",
        displayName = "GPT-4o Transcribe",
        provider = "OpenAI",
        description = "Latest OpenAI transcription model with superior accuracy, better accent recognition, and reduced hallucinations compared to Whisper.",
        apiKeyLabel = "OpenAI API Key",
        apiKeyHint = "sk-...",
        apiKeyDescription = "Get your API key from https://platform.openai.com/api-keys",
        isRecommended = true
    ),
    GPT_4O_MINI_TRANSCRIBE(
        id = "gpt-4o-mini-transcribe",
        displayName = "GPT-4o Mini Transcribe",
        provider = "OpenAI",
        description = "Faster and more cost-effective transcription model with excellent accuracy. Best balance of speed, cost, and quality.",
        apiKeyLabel = "OpenAI API Key",
        apiKeyHint = "sk-...",
        apiKeyDescription = "Get your API key from https://platform.openai.com/api-keys",
        isRecommended = true
    ),
    
    // Google Speech API
    GEMINI_SPEECH(
        id = "gemini-speech",
        displayName = "Google Cloud Speech",
        provider = "Google",
        description = "Google Cloud Speech-to-Text API with high accuracy and 125+ language support.",
        apiKeyLabel = "Google Cloud API Key",
        apiKeyHint = "AIza...",
        apiKeyDescription = "Get your API key from Google Cloud Console > APIs & Services > Credentials",
        isRecommended = true
    ),
    
    // Groq Models - Ultra Fast Whisper
    GROQ_WHISPER_LARGE_V3(
        id = "whisper-large-v3",
        displayName = "Groq Whisper Large v3",
        provider = "Groq",
        description = "Ultra-fast Whisper Large v3 model hosted by Groq. Lightning speed with excellent accuracy.",
        apiKeyLabel = "Groq API Key",
        apiKeyHint = "gsk_...",
        apiKeyDescription = "Get your API key from https://console.groq.com/keys",
        isRecommended = true
    ),
    GROQ_WHISPER_LARGE_V3_TURBO(
        id = "whisper-large-v3-turbo",
        displayName = "Groq Whisper Large v3 Turbo",
        provider = "Groq",
        description = "Fastest Whisper model available. Optimized for speed while maintaining high accuracy.",
        apiKeyLabel = "Groq API Key",
        apiKeyHint = "gsk_...",
        apiKeyDescription = "Get your API key from https://console.groq.com/keys",
        isRecommended = true
    )
}

// For Flow emissions
sealed class TranscriptionResult {
    data class Success(val text: String, val confidence: Float = 1.0f) : TranscriptionResult()
    data class Error(val message: String, val exception: Throwable? = null) : TranscriptionResult()
    object Processing : TranscriptionResult()
}