package com.voiceinput.assistant;

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
public final class VoiceInputApplication_MembersInjector implements MembersInjector<VoiceInputApplication> {
  private final Provider<ConfigurationManager> configManagerProvider;

  public VoiceInputApplication_MembersInjector(
      Provider<ConfigurationManager> configManagerProvider) {
    this.configManagerProvider = configManagerProvider;
  }

  public static MembersInjector<VoiceInputApplication> create(
      Provider<ConfigurationManager> configManagerProvider) {
    return new VoiceInputApplication_MembersInjector(configManagerProvider);
  }

  @Override
  public void injectMembers(VoiceInputApplication instance) {
    injectConfigManager(instance, configManagerProvider.get());
  }

  @InjectedFieldSignature("com.voiceinput.assistant.VoiceInputApplication.configManager")
  public static void injectConfigManager(VoiceInputApplication instance,
      ConfigurationManager configManager) {
    instance.configManager = configManager;
  }
}
