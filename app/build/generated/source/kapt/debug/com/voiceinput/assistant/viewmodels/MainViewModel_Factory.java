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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<VoiceInputRepository> repositoryProvider;

  private final Provider<ConfigurationManager> configManagerProvider;

  public MainViewModel_Factory(Provider<VoiceInputRepository> repositoryProvider,
      Provider<ConfigurationManager> configManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.configManagerProvider = configManagerProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repositoryProvider.get(), configManagerProvider.get());
  }

  public static MainViewModel_Factory create(Provider<VoiceInputRepository> repositoryProvider,
      Provider<ConfigurationManager> configManagerProvider) {
    return new MainViewModel_Factory(repositoryProvider, configManagerProvider);
  }

  public static MainViewModel newInstance(VoiceInputRepository repository,
      ConfigurationManager configManager) {
    return new MainViewModel(repository, configManager);
  }
}
