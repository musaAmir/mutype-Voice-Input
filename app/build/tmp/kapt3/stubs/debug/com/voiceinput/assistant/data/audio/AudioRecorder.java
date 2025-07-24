package com.voiceinput.assistant.data.audio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/voiceinput/assistant/data/audio/AudioRecorder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioData", "Ljava/io/ByteArrayOutputStream;", "audioRecord", "Landroid/media/AudioRecord;", "isRecording", "", "convertToWav", "", "pcmData", "createWavHeader", "pcmDataSize", "", "startRecording", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "Companion", "app_debug"})
@javax.inject.Singleton
public final class AudioRecorder {
    private final android.content.Context context = null;
    private android.media.AudioRecord audioRecord;
    private boolean isRecording = false;
    private final java.io.ByteArrayOutputStream audioData = null;
    @org.jetbrains.annotations.NotNull
    public static final com.voiceinput.assistant.data.audio.AudioRecorder.Companion Companion = null;
    private static final int SAMPLE_RATE = 16000;
    private static final int CHANNEL_CONFIG = android.media.AudioFormat.CHANNEL_IN_MONO;
    private static final int AUDIO_FORMAT = android.media.AudioFormat.ENCODING_PCM_16BIT;
    private static final int BUFFER_SIZE_FACTOR = 2;
    
    @javax.inject.Inject
    public AudioRecorder(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object startRecording(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object stopRecording(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super byte[]> continuation) {
        return null;
    }
    
    private final byte[] convertToWav(byte[] pcmData) {
        return null;
    }
    
    private final byte[] createWavHeader(int pcmDataSize) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/voiceinput/assistant/data/audio/AudioRecorder$Companion;", "", "()V", "AUDIO_FORMAT", "", "BUFFER_SIZE_FACTOR", "CHANNEL_CONFIG", "SAMPLE_RATE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}