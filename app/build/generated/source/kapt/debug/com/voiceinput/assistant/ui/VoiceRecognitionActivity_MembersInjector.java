package com.voiceinput.assistant.ui;

import com.voiceinput.assistant.data.repository.ConfigurationManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class VoiceRecognitionActivity_MembersInjector implements MembersInjector<VoiceRecognitionActivity> {
  private final Provider<ConfigurationManager> configManagerProvider;

  public VoiceRecognitionActivity_MembersInjector(
      Provider<ConfigurationManager> configManagerProvider) {
    this.configManagerProvider = configManagerProvider;
  }

  public static MembersInjector<VoiceRecognitionActivity> create(
      Provider<ConfigurationManager> configManagerProvider) {
    return new VoiceRecognitionActivity_MembersInjector(configManagerProvider);
  }

  @Override
  public void injectMembers(VoiceRecognitionActivity instance) {
    injectConfigManager(instance, configManagerProvider.get());
  }

  @InjectedFieldSignature("com.voiceinput.assistant.ui.VoiceRecognitionActivity.configManager")
  public static void injectConfigManager(VoiceRecognitionActivity instance,
      ConfigurationManager configManager) {
    instance.configManager = configManager;
  }
}
