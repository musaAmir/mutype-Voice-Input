package com.voiceinput.assistant.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0019\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J!\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J!\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/voiceinput/assistant/data/repository/VoiceInputRepository;", "", "apiService", "Lcom/voiceinput/assistant/data/network/OpenAIApiService;", "groqApiService", "Lcom/voiceinput/assistant/data/network/GroqApiService;", "geminiApiService", "Lcom/voiceinput/assistant/data/network/GeminiApiService;", "audioRecorder", "Lcom/voiceinput/assistant/data/audio/AudioRecorder;", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "(Lcom/voiceinput/assistant/data/network/OpenAIApiService;Lcom/voiceinput/assistant/data/network/GroqApiService;Lcom/voiceinput/assistant/data/network/GeminiApiService;Lcom/voiceinput/assistant/data/audio/AudioRecorder;Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "_transcriptionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/voiceinput/assistant/data/model/TranscriptionResult;", "isRecording", "", "transcriptionState", "Lkotlinx/coroutines/flow/StateFlow;", "getTranscriptionState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearTranscription", "", "resetRecordingState", "startRecording", "stopRecording", "testConnection", "config", "Lcom/voiceinput/assistant/data/model/VoiceInputConfig;", "(Lcom/voiceinput/assistant/data/model/VoiceInputConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transcribeWithGemini", "audioFile", "Ljava/io/File;", "(Ljava/io/File;Lcom/voiceinput/assistant/data/model/VoiceInputConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transcribeWithGroq", "transcribeWithWhisper", "app_debug"})
@javax.inject.Singleton
public final class VoiceInputRepository {
    private final com.voiceinput.assistant.data.network.OpenAIApiService apiService = null;
    private final com.voiceinput.assistant.data.network.GroqApiService groqApiService = null;
    private final com.voiceinput.assistant.data.network.GeminiApiService geminiApiService = null;
    private final com.voiceinput.assistant.data.audio.AudioRecorder audioRecorder = null;
    private final com.voiceinput.assistant.data.repository.ConfigurationManager configManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.voiceinput.assistant.data.model.TranscriptionResult> _transcriptionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.data.model.TranscriptionResult> transcriptionState = null;
    private boolean isRecording = false;
    
    @javax.inject.Inject
    public VoiceInputRepository(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.network.OpenAIApiService apiService, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.network.GroqApiService groqApiService, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.network.GeminiApiService geminiApiService, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.audio.AudioRecorder audioRecorder, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager configManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.data.model.TranscriptionResult> getTranscriptionState() {
        return null;
    }
    
    public final void startRecording() {
    }
    
    public final void stopRecording() {
    }
    
    public final void clearTranscription() {
    }
    
    public final void resetRecordingState() {
    }
    
    private final java.lang.Object transcribeWithWhisper(java.io.File audioFile, com.voiceinput.assistant.data.model.VoiceInputConfig config, kotlin.coroutines.Continuation<? super com.voiceinput.assistant.data.model.TranscriptionResult> continuation) {
        return null;
    }
    
    private final java.lang.Object transcribeWithGroq(java.io.File audioFile, com.voiceinput.assistant.data.model.VoiceInputConfig config, kotlin.coroutines.Continuation<? super com.voiceinput.assistant.data.model.TranscriptionResult> continuation) {
        return null;
    }
    
    private final java.lang.Object transcribeWithGemini(java.io.File audioFile, com.voiceinput.assistant.data.model.VoiceInputConfig config, kotlin.coroutines.Continuation<? super com.voiceinput.assistant.data.model.TranscriptionResult> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object testConnection(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.model.VoiceInputConfig config, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}