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
public final class SettingsActivity_MembersInjector implements MembersInjector<SettingsActivity> {
  private final Provider<ConfigurationManager> configManagerProvider;

  public SettingsActivity_MembersInjector(Provider<ConfigurationManager> configManagerProvider) {
    this.configManagerProvider = configManagerProvider;
  }

  public static MembersInjector<SettingsActivity> create(
      Provider<ConfigurationManager> configManagerProvider) {
    return new SettingsActivity_MembersInjector(configManagerProvider);
  }

  @Override
  public void injectMembers(SettingsActivity instance) {
    injectConfigManager(instance, configManagerProvider.get());
  }

  @InjectedFieldSignature("com.voiceinput.assistant.ui.SettingsActivity.configManager")
  public static void injectConfigManager(SettingsActivity instance,
      ConfigurationManager configManager) {
    instance.configManager = configManager;
  }
}
