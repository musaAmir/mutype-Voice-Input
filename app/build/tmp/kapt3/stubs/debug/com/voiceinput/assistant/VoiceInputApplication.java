package com.voiceinput.assistant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/voiceinput/assistant/VoiceInputApplication;", "Landroid/app/Application;", "()V", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "getConfigManager", "()Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "setConfigManager", "(Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "onCreate", "", "Companion", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class VoiceInputApplication extends android.app.Application {
    @javax.inject.Inject
    public com.voiceinput.assistant.data.repository.ConfigurationManager configManager;
    @org.jetbrains.annotations.NotNull
    public static final com.voiceinput.assistant.VoiceInputApplication.Companion Companion = null;
    private static com.voiceinput.assistant.VoiceInputApplication instance;
    
    public VoiceInputApplication() {
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/voiceinput/assistant/VoiceInputApplication$Companion;", "", "()V", "<set-?>", "Lcom/voiceinput/assistant/VoiceInputApplication;", "instance", "getInstance", "()Lcom/voiceinput/assistant/VoiceInputApplication;", "setInstance", "(Lcom/voiceinput/assistant/VoiceInputApplication;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.voiceinput.assistant.VoiceInputApplication getInstance() {
            return null;
        }
        
        private final void setInstance(com.voiceinput.assistant.VoiceInputApplication p0) {
        }
    }
}