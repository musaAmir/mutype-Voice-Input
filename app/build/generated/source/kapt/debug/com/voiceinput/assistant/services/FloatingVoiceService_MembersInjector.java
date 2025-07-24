package com.voiceinput.assistant.services;

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
public final class FloatingVoiceService_MembersInjector implements MembersInjector<FloatingVoiceService> {
  private final Provider<ConfigurationManager> configManagerProvider;

  public FloatingVoiceService_MembersInjector(
      Provider<ConfigurationManager> configManagerProvider) {
    this.configManagerProvider = configManagerProvider;
  }

  public static MembersInjector<FloatingVoiceService> create(
      Provider<ConfigurationManager> configManagerProvider) {
    return new FloatingVoiceService_MembersInjector(configManagerProvider);
  }

  @Override
  public void injectMembers(FloatingVoiceService instance) {
    injectConfigManager(instance, configManagerProvider.get());
  }

  @InjectedFieldSignature("com.voiceinput.assistant.services.FloatingVoiceService.configManager")
  public static void injectConfigManager(FloatingVoiceService instance,
      ConfigurationManager configManager) {
    instance.configManager = configManager;
  }
}
