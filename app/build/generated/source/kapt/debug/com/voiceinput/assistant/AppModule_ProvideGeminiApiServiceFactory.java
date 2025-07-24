package com.voiceinput.assistant;

import com.voiceinput.assistant.data.network.GeminiApiService;
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
public final class AppModule_ProvideGeminiApiServiceFactory implements Factory<GeminiApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideGeminiApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GeminiApiService get() {
    return provideGeminiApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideGeminiApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideGeminiApiServiceFactory(retrofitProvider);
  }

  public static GeminiApiService provideGeminiApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGeminiApiService(retrofit));
  }
}
