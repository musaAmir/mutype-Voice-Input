package com.voiceinput.assistant.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/voiceinput/assistant/data/network/GeminiApiService;", "", "transcribeWithGemini", "Lcom/voiceinput/assistant/data/network/GeminiTranscriptionResponse;", "apiKey", "", "request", "Lcom/voiceinput/assistant/data/network/GeminiSpeechRequest;", "(Ljava/lang/String;Lcom/voiceinput/assistant/data/network/GeminiSpeechRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GeminiApiService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "v1/speech:recognize")
    public abstract java.lang.Object transcribeWithGemini(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Header(value = "X-Goog-Api-Key")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.voiceinput.assistant.data.network.GeminiSpeechRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.voiceinput.assistant.data.network.GeminiTranscriptionResponse> continuation);
}