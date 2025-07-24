package com.voiceinput.assistant;

import com.voiceinput.assistant.data.network.GroqApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class AppModule_ProvideGroqApiServiceFactory implements Factory<GroqApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideGroqApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GroqApiService get() {
    return provideGroqApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideGroqApiServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideGroqApiServiceFactory(retrofitProvider);
  }

  public static GroqApiService provideGroqApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGroqApiService(retrofit));
  }
}
