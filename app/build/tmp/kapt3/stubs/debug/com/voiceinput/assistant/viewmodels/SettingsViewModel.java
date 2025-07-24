package com.voiceinput.assistant.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eJ\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eJ\b\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ1\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020!H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0019J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000fH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "repository", "Lcom/voiceinput/assistant/data/repository/VoiceInputRepository;", "(Lcom/voiceinput/assistant/data/repository/ConfigurationManager;Lcom/voiceinput/assistant/data/repository/VoiceInputRepository;)V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/voiceinput/assistant/viewmodels/SettingsUiState;", "availableModels", "", "Lcom/voiceinput/assistant/data/model/AIModel;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getLanguageCode", "", "index", "", "getLanguageDisplayNames", "getLanguageIndex", "languageCode", "getModelDisplayNames", "loadCurrentSettings", "", "onModelSelected", "saveSettings", "selectedModelIndex", "apiKey", "selectedLanguageIndex", "temperature", "", "(ILjava/lang/String;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testConnection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateApiKey", "updateModelInfo", "model", "Event", "app_debug"})
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    private final com.voiceinput.assistant.data.repository.ConfigurationManager configManager = null;
    private final com.voiceinput.assistant.data.repository.VoiceInputRepository repository = null;
    private final java.util.List<com.voiceinput.assistant.data.model.AIModel> availableModels = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.voiceinput.assistant.viewmodels.SettingsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.viewmodels.SettingsUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.voiceinput.assistant.viewmodels.SettingsViewModel.Event> _events = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.voiceinput.assistant.viewmodels.SettingsViewModel.Event> events = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager configManager, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.VoiceInputRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.voiceinput.assistant.viewmodels.SettingsUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.voiceinput.assistant.viewmodels.SettingsViewModel.Event> getEvents() {
        return null;
    }
    
    private final void loadCurrentSettings() {
    }
    
    public final void onModelSelected(int index) {
    }
    
    private final void updateModelInfo(com.voiceinput.assistant.data.model.AIModel model) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getModelDisplayNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getLanguageDisplayNames() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSettings(int selectedModelIndex, @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, int selectedLanguageIndex, float temperature, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void updateApiKey(@org.jetbrains.annotations.NotNull
    java.lang.String apiKey) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object testConnection(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final int getLanguageIndex(java.lang.String languageCode) {
        return 0;
    }
    
    private final java.lang.String getLanguageCode(int index) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event;", "", "()V", "SettingsSaved", "TestConnectionError", "TestConnectionSuccess", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$SettingsSaved;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$TestConnectionError;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$TestConnectionSuccess;", "app_debug"})
    public static abstract class Event {
        
        private Event() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$SettingsSaved;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event;", "()V", "app_debug"})
        public static final class SettingsSaved extends com.voiceinput.assistant.viewmodels.SettingsViewModel.Event {
            @org.jetbrains.annotations.NotNull
            public static final com.voiceinput.assistant.viewmodels.SettingsViewModel.Event.SettingsSaved INSTANCE = null;
            
            private SettingsSaved() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$TestConnectionSuccess;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event;", "()V", "app_debug"})
        public static final class TestConnectionSuccess extends com.voiceinput.assistant.viewmodels.SettingsViewModel.Event {
            @org.jetbrains.annotations.NotNull
            public static final com.voiceinput.assistant.viewmodels.SettingsViewModel.Event.TestConnectionSuccess INSTANCE = null;
            
            private TestConnectionSuccess() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event$TestConnectionError;", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class TestConnectionError extends com.voiceinput.assistant.viewmodels.SettingsViewModel.Event {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String message = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.voiceinput.assistant.viewmodels.SettingsViewModel.Event.TestConnectionError copy(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull
            @java.lang.Override
            public java.lang.String toString() {
                return null;
            }
            
            public TestConnectionError(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMessage() {
                return null;
            }
        }
    }
}