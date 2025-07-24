package com.voiceinput.assistant.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/voiceinput/assistant/data/repository/VoiceInputRepository;", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "(Lcom/voiceinput/assistant/data/repository/VoiceInputRepository;Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "isRecording", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "transcriptionState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/voiceinput/assistant/data/model/TranscriptionResult;", "getTranscriptionState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearTranscription", "", "getCurrentModelDisplay", "", "isConfigured", "onPermissionsGranted", "startFreshRecordingSession", "startRecording", "stopRecording", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.voiceinput.assistant.data.repository.VoiceInputRepository repository = null;
    private final com.voiceinput.assistant.data.repository.ConfigurationManager configManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.data.model.TranscriptionResult> transcriptionState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> isRecording = null;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.VoiceInputRepository repository, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager configManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.data.model.TranscriptionResult> getTranscriptionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> isRecording() {
        return null;
    }
    
    public final void startRecording() {
    }
    
    public final void stopRecording() {
    }
    
    public final void clearTranscription() {
    }
    
    public final void startFreshRecordingSession() {
    }
    
    public final void onPermissionsGranted() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentModelDisplay() {
        return null;
    }
    
    public final boolean isConfigured() {
        return false;
    }
}