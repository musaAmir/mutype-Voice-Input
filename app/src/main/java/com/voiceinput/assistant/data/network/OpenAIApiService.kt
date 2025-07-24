package com.voiceinput.assistant.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.http.*
import java.io.File

interface OpenAIApiService {

    @Multipart
    @POST("v1/audio/transcriptions")
    suspend fun transcribeWithWhisper(
        @Header("Authorization") authorization: String,
        @Part file: MultipartBody.Part,
        @Part("model") model: RequestBody,
        @Part("language") language: RequestBody? = null,
        @Part("temperature") temperature: RequestBody? = null
    ): TranscriptionResponse

}

object OpenAIApiClient {
    fun create(file: File): MultipartBody.Part {
        val requestFile = file.asRequestBody("audio/mpeg".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("file", file.name, requestFile)
    }

    fun createPartFromString(value: String): RequestBody {
        return value.toRequestBody("text/plain".toMediaTypeOrNull())
    }
}

data class WhisperRequest(
    val file: ByteArray,
    val model: String = "whisper-1",
    val language: String? = null
)

data class TranscriptionResponse(
    val text: String,
    val language: String? = null
)