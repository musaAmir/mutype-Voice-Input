package com.voiceinput.assistant;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/voiceinput/assistant/AppModule;", "", "()V", "provideGeminiApiService", "Lcom/voiceinput/assistant/data/network/GeminiApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideGeminiRetrofit", "gson", "Lcom/google/gson/Gson;", "provideGroqApiService", "Lcom/voiceinput/assistant/data/network/GroqApiService;", "provideGroqRetrofit", "provideGson", "provideOpenAIApiService", "Lcom/voiceinput/assistant/data/network/OpenAIApiService;", "provideRetrofit", "app_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.voiceinput.assistant.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.voiceinput.assistant.data.network.OpenAIApiService provideOpenAIApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "groq")
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideGroqRetrofit(@org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.voiceinput.assistant.data.network.GroqApiService provideGroqApiService(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "groq")
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "gemini")
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideGeminiRetrofit(@org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.voiceinput.assistant.data.network.GeminiApiService provideGeminiApiService(@org.jetbrains.annotations.NotNull
    @javax.inject.Named(value = "gemini")
    retrofit2.Retrofit retrofit) {
        return null;
    }
}