package com.voiceinput.assistant.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\"\u0010\u001d\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/voiceinput/assistant/services/FloatingVoiceService;", "Landroid/app/Service;", "()V", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "getConfigManager", "()Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "setConfigManager", "(Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "floatingButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "floatingView", "Landroid/view/View;", "initialTouchX", "", "initialTouchY", "initialX", "", "initialY", "windowManager", "Landroid/view/WindowManager;", "createFloatingButton", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "setupDragFunctionality", "startVoiceRecognition", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class FloatingVoiceService extends android.app.Service {
    @javax.inject.Inject
    public com.voiceinput.assistant.data.repository.ConfigurationManager configManager;
    private android.view.WindowManager windowManager;
    private android.view.View floatingView;
    private com.google.android.material.floatingactionbutton.FloatingActionButton floatingButton;
    private int initialX = 0;
    private int initialY = 0;
    private float initialTouchX = 0.0F;
    private float initialTouchY = 0.0F;
    
    public FloatingVoiceService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.repository.ConfigurationManager getConfigManager() {
        return null;
    }
    
    public final void setConfigManager(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void createFloatingButton() {
    }
    
    private final void setupDragFunctionality() {
    }
    
    private final void startVoiceRecognition() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}