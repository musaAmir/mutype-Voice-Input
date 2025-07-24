package com.voiceinput.assistant.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.*
import java.io.File

interface GroqApiService {

    @Multipart
    @POST("openai/v1/audio/transcriptions")
    suspend fun transcribeWithGroqWhisper(
        @Header("Authorization") authorization: String,
        @Part file: MultipartBody.Part,
        @Part("model") model: RequestBody,
        @Part("language") language: RequestBody? = null,
        @Part("temperature") temperature: RequestBody? = null,
        @Part("response_format") responseFormat: RequestBody? = null
    ): TranscriptionResponse

}

object GroqApiClient {
    fun create(file: File): MultipartBody.Part {
        val requestFile = file.asRequestBody("audio/mpeg".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("file", file.name, requestFile)
    }

    fun createPartFromString(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }
}

data class GroqTranscriptionRequest(
    val file: ByteArray,
    val model: String = "whisper-large-v3",
    val language: String? = null,
    val temperature: Float = 0.0f,
    val response_format: String = "json"
)