package com.voiceinput.assistant.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002\'(B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0010J\u000e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "prefs", "Landroid/content/SharedPreferences;", "clearConfiguration", "", "getApiKey", "", "getAppTheme", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager$AppTheme;", "getAutoStartRecording", "", "getCurrentConfig", "Lcom/voiceinput/assistant/data/model/VoiceInputConfig;", "getDefaultConfig", "getFloatingButtonEnabled", "getSelectedLanguage", "getSelectedModel", "Lcom/voiceinput/assistant/data/model/AIModel;", "getTemperature", "", "getTranscriptionDelay", "", "isConfigured", "saveConfiguration", "config", "setAppTheme", "theme", "setAutoStartRecording", "autoStart", "setFloatingButtonEnabled", "enabled", "setTranscriptionDelay", "delayMs", "AppTheme", "Companion", "app_debug"})
@javax.inject.Singleton
public final class ConfigurationManager {
    private final android.content.Context context = null;
    private final com.google.gson.Gson gson = null;
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    public static final com.voiceinput.assistant.data.repository.ConfigurationManager.Companion Companion = null;
    private static final java.lang.String KEY_CONFIG = "current_config";
    private static final java.lang.String KEY_API_KEY = "api_key";
    private static final java.lang.String KEY_MODEL = "selected_model";
    private static final java.lang.String KEY_LANGUAGE = "selected_language";
    private static final java.lang.String KEY_TEMPERATURE = "temperature";
    private static final java.lang.String KEY_AUTO_START_RECORDING = "auto_start_recording";
    private static final java.lang.String KEY_TRANSCRIPTION_DELAY = "transcription_delay";
    private static final java.lang.String KEY_APP_THEME = "app_theme";
    private static final java.lang.String KEY_FLOATING_BUTTON_ENABLED = "floating_button_enabled";
    
    @javax.inject.Inject
    public ConfigurationManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        super();
    }
    
    public final void saveConfiguration(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.model.VoiceInputConfig config) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.voiceinput.assistant.data.model.VoiceInputConfig getCurrentConfig() {
        return null;
    }
    
    private final com.voiceinput.assistant.data.model.VoiceInputConfig getDefaultConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.model.AIModel getSelectedModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedLanguage() {
        return null;
    }
    
    public final float getTemperature() {
        return 0.0F;
    }
    
    public final boolean getAutoStartRecording() {
        return false;
    }
    
    public final void setAutoStartRecording(boolean autoStart) {
    }
    
    public final int getTranscriptionDelay() {
        return 0;
    }
    
    public final void setTranscriptionDelay(int delayMs) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.repository.ConfigurationManager.AppTheme getAppTheme() {
        return null;
    }
    
    public final void setAppTheme(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager.AppTheme theme) {
    }
    
    public final boolean getFloatingButtonEnabled() {
        return false;
    }
    
    public final void setFloatingButtonEnabled(boolean enabled) {
    }
    
    public final boolean isConfigured() {
        return false;
    }
    
    public final void clearConfiguration() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/voiceinput/assistant/data/repository/ConfigurationManager$AppTheme;", "", "(Ljava/lang/String;I)V", "DARK_BLUE", "AMOLED_BLACK", "DARK_GRAY", "app_debug"})
    public static enum AppTheme {
        /*public static final*/ DARK_BLUE /* = new DARK_BLUE() */,
        /*public static final*/ AMOLED_BLACK /* = new AMOLED_BLACK() */,
        /*public static final*/ DARK_GRAY /* = new DARK_GRAY() */;
        
        AppTheme() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/voiceinput/assistant/data/repository/ConfigurationManager$Companion;", "", "()V", "KEY_API_KEY", "", "KEY_APP_THEME", "KEY_AUTO_START_RECORDING", "KEY_CONFIG", "KEY_FLOATING_BUTTON_ENABLED", "KEY_LANGUAGE", "KEY_MODEL", "KEY_TEMPERATURE", "KEY_TRANSCRIPTION_DELAY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}