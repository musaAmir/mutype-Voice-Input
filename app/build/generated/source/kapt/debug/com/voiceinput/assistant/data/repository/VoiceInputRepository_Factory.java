package com.voiceinput.assistant.data.repository;

import com.voiceinput.assistant.data.audio.AudioRecorder;
import com.voiceinput.assistant.data.network.GeminiApiService;
import com.voiceinput.assistant.data.network.GroqApiService;
import com.voiceinput.assistant.data.network.OpenAIApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class VoiceInputRepository_Factory implements Factory<VoiceInputRepository> {
  private final Provider<OpenAIApiService> apiServiceProvider;

  private final Provider<GroqApiService> groqApiServiceProvider;

  private final Provider<GeminiApiService> geminiApiServiceProvider;

  private final Provider<AudioRecorder> audioRecorderProvider;

  private final Provider<ConfigurationManager> configManagerProvider;

  public VoiceInputRepository_Factory(Provider<OpenAIApiService> apiServiceProvider,
      Provider<GroqApiService> groqApiServiceProvider,
      Provider<GeminiApiService> geminiApiServiceProvider,
      Provider<AudioRecorder> audioRecorderProvider,
      Provider<ConfigurationManager> configManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.groqApiServiceProvider = groqApiServiceProvider;
    this.geminiApiServiceProvider = geminiApiServiceProvider;
    this.audioRecorderProvider = audioRecorderProvider;
    this.configManagerProvider = configManagerProvider;
  }

  @Override
  public VoiceInputRepository get() {
    return newInstance(apiServiceProvider.get(), groqApiServiceProvider.get(), geminiApiServiceProvider.get(), audioRecorderProvider.get(), configManagerProvider.get());
  }

  public static VoiceInputRepository_Factory create(Provider<OpenAIApiService> apiServiceProvider,
      Provider<GroqApiService> groqApiServiceProvider,
      Provider<GeminiApiService> geminiApiServiceProvider,
      Provider<AudioRecorder> audioRecorderProvider,
      Provider<ConfigurationManager> configManagerProvider) {
    return new VoiceInputRepository_Factory(apiServiceProvider, groqApiServiceProvider, geminiApiServiceProvider, audioRecorderProvider, configManagerProvider);
  }

  public static VoiceInputRepository newInstance(OpenAIApiService apiService,
      GroqApiService groqApiService, GeminiApiService geminiApiService, AudioRecorder audioRecorder,
      ConfigurationManager configManager) {
    return new VoiceInputRepository(apiService, groqApiService, geminiApiService, audioRecorder, configManager);
  }
}
