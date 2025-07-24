package com.voiceinput.assistant.viewmodels;

import com.voiceinput.assistant.data.repository.ConfigurationManager;
import com.voiceinput.assistant.data.repository.VoiceInputRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<ConfigurationManager> configManagerProvider;

  private final Provider<VoiceInputRepository> repositoryProvider;

  public SettingsViewModel_Factory(Provider<ConfigurationManager> configManagerProvider,
      Provider<VoiceInputRepository> repositoryProvider) {
    this.configManagerProvider = configManagerProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(configManagerProvider.get(), repositoryProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<ConfigurationManager> configManagerProvider,
      Provider<VoiceInputRepository> repositoryProvider) {
    return new SettingsViewModel_Factory(configManagerProvider, repositoryProvider);
  }

  public static SettingsViewModel newInstance(ConfigurationManager configManager,
      VoiceInputRepository repository) {
    return new SettingsViewModel(configManager, repository);
  }
}
