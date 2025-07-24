package com.voiceinput.assistant.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BS\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/voiceinput/assistant/data/model/AIModel;", "", "id", "", "displayName", "provider", "description", "apiKeyLabel", "apiKeyHint", "apiKeyDescription", "supportsMultipleLanguages", "", "isRecommended", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getApiKeyDescription", "()Ljava/lang/String;", "getApiKeyHint", "getApiKeyLabel", "getDescription", "getDisplayName", "getId", "()Z", "getProvider", "getSupportsMultipleLanguages", "WHISPER_1", "GPT_4O_TRANSCRIBE", "GPT_4O_MINI_TRANSCRIBE", "GEMINI_SPEECH", "GROQ_WHISPER_LARGE_V3", "GROQ_WHISPER_LARGE_V3_TURBO", "app_debug"})
public enum AIModel {
    /*public static final*/ WHISPER_1 /* = new WHISPER_1(null, null, null, null, null, null, null, false, false) */,
    /*public static final*/ GPT_4O_TRANSCRIBE /* = new GPT_4O_TRANSCRIBE(null, null, null, null, null, null, null, false, false) */,
    /*public static final*/ GPT_4O_MINI_TRANSCRIBE /* = new GPT_4O_MINI_TRANSCRIBE(null, null, null, null, null, null, null, false, false) */,
    /*public static final*/ GEMINI_SPEECH /* = new GEMINI_SPEECH(null, null, null, null, null, null, null, false, false) */,
    /*public static final*/ GROQ_WHISPER_LARGE_V3 /* = new GROQ_WHISPER_LARGE_V3(null, null, null, null, null, null, null, false, false) */,
    /*public static final*/ GROQ_WHISPER_LARGE_V3_TURBO /* = new GROQ_WHISPER_LARGE_V3_TURBO(null, null, null, null, null, null, null, false, false) */;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String displayName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String provider = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String apiKeyLabel = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String apiKeyHint = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String apiKeyDescription = null;
    private final boolean supportsMultipleLanguages = false;
    private final boolean isRecommended = false;
    
    AIModel(java.lang.String id, java.lang.String displayName, java.lang.String provider, java.lang.String description, java.lang.String apiKeyLabel, java.lang.String apiKeyHint, java.lang.String apiKeyDescription, boolean supportsMultipleLanguages, boolean isRecommended) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApiKeyLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApiKeyHint() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApiKeyDescription() {
        return null;
    }
    
    public final boolean getSupportsMultipleLanguages() {
        return false;
    }
    
    public final boolean isRecommended() {
        return false;
    }
}