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
public final class VoiceRecognitionActivityModern_MembersInjector implements MembersInjector<VoiceRecognitionActivityModern> {
  private final Provider<ConfigurationManager> configManagerProvider;

  public VoiceRecognitionActivityModern_MembersInjector(
      Provider<ConfigurationManager> configManagerProvider) {
    this.configManagerProvider = configManagerProvider;
  }

  public static MembersInjector<VoiceRecognitionActivityModern> create(
      Provider<ConfigurationManager> configManagerProvider) {
    return new VoiceRecognitionActivityModern_MembersInjector(configManagerProvider);
  }

  @Override
  public void injectMembers(VoiceRecognitionActivityModern instance) {
    injectConfigManager(instance, configManagerProvider.get());
  }

  @InjectedFieldSignature("com.voiceinput.assistant.ui.VoiceRecognitionActivityModern.configManager")
  public static void injectConfigManager(VoiceRecognitionActivityModern instance,
      ConfigurationManager configManager) {
    instance.configManager = configManager;
  }
}
