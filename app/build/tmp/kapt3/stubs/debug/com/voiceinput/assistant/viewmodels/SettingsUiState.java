package com.voiceinput.assistant.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003J\t\u0010\'\u001a\u00020\bH\u00c6\u0003J\t\u0010(\u001a\u00020\bH\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003Jc\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u00c6\u0001J\u0013\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\t\u0010.\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006/"}, d2 = {"Lcom/voiceinput/assistant/viewmodels/SettingsUiState;", "", "selectedModelIndex", "", "selectedLanguageIndex", "temperature", "", "apiKey", "", "selectedModel", "Lcom/voiceinput/assistant/data/model/AIModel;", "selectedModelDescription", "currentApiKeyLabel", "currentApiKeyHint", "currentApiKeyDescription", "(IIFLjava/lang/String;Lcom/voiceinput/assistant/data/model/AIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "canTestConnection", "", "getCanTestConnection", "()Z", "getCurrentApiKeyDescription", "getCurrentApiKeyHint", "getCurrentApiKeyLabel", "getSelectedLanguageIndex", "()I", "getSelectedModel", "()Lcom/voiceinput/assistant/data/model/AIModel;", "getSelectedModelDescription", "getSelectedModelIndex", "getTemperature", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class SettingsUiState {
    private final int selectedModelIndex = 0;
    private final int selectedLanguageIndex = 0;
    private final float temperature = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String apiKey = null;
    @org.jetbrains.annotations.NotNull
    private final com.voiceinput.assistant.data.model.AIModel selectedModel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String selectedModelDescription = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String currentApiKeyLabel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String currentApiKeyHint = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String currentApiKeyDescription = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.viewmodels.SettingsUiState copy(int selectedModelIndex, int selectedLanguageIndex, float temperature, @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.model.AIModel selectedModel, @org.jetbrains.annotations.NotNull
    java.lang.String selectedModelDescription, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyLabel, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyHint, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyDescription) {
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
    
    public SettingsUiState() {
        super();
    }
    
    public SettingsUiState(int selectedModelIndex, int selectedLanguageIndex, float temperature, @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.model.AIModel selectedModel, @org.jetbrains.annotations.NotNull
    java.lang.String selectedModelDescription, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyLabel, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyHint, @org.jetbrains.annotations.NotNull
    java.lang.String currentApiKeyDescription) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getSelectedModelIndex() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getSelectedLanguageIndex() {
        return 0;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float getTemperature() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.model.AIModel component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.model.AIModel getSelectedModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedModelDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentApiKeyLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentApiKeyHint() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentApiKeyDescription() {
        return null;
    }
    
    public final boolean getCanTestConnection() {
        return false;
    }
}