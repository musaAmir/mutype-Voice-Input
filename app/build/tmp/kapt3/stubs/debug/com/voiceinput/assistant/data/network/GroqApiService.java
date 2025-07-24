package com.voiceinput.assistant.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/voiceinput/assistant/data/network/GroqApiService;", "", "transcribeWithGroqWhisper", "Lcom/voiceinput/assistant/data/network/TranscriptionResponse;", "authorization", "", "file", "Lokhttp3/MultipartBody$Part;", "model", "Lokhttp3/RequestBody;", "language", "temperature", "responseFormat", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GroqApiService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "openai/v1/audio/transcriptions")
    @retrofit2.http.Multipart
    public abstract java.lang.Object transcribeWithGroqWhisper(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String authorization, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "model")
    okhttp3.RequestBody model, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Part(value = "language")
    okhttp3.RequestBody language, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Part(value = "temperature")
    okhttp3.RequestBody temperature, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Part(value = "response_format")
    okhttp3.RequestBody responseFormat, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.voiceinput.assistant.data.network.TranscriptionResponse> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}