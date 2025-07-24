package com.voiceinput.assistant.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0014J\b\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/voiceinput/assistant/ui/VoiceRecognitionActivityModern;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "audioVisualizer", "Lcom/voiceinput/assistant/ui/AudioVisualizerView;", "btnCancel", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "getConfigManager", "()Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "setConfigManager", "(Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "isRecording", "", "statusText", "Landroid/widget/TextView;", "viewModel", "Lcom/voiceinput/assistant/viewmodels/MainViewModel;", "getViewModel", "()Lcom/voiceinput/assistant/viewmodels/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "cancelRecording", "", "initializeViews", "observeViewModel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupClickListeners", "showError", "message", "", "startRecording", "stopRecording", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class VoiceRecognitionActivityModern extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.voiceinput.assistant.data.repository.ConfigurationManager configManager;
    private com.voiceinput.assistant.ui.AudioVisualizerView audioVisualizer;
    private com.google.android.material.floatingactionbutton.FloatingActionButton btnCancel;
    private android.widget.TextView statusText;
    private boolean isRecording = false;
    
    public VoiceRecognitionActivityModern() {
        super();
    }
    
    private final com.voiceinput.assistant.viewmodels.MainViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.repository.ConfigurationManager getConfigManager() {
        return null;
    }
    
    public final void setConfigManager(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initializeViews() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void startRecording() {
    }
    
    private final void stopRecording() {
    }
    
    private final void cancelRecording() {
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void observeViewModel() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}