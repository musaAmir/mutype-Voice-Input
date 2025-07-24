package com.voiceinput.assistant;

import com.voiceinput.assistant.data.network.OpenAIApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideOpenAIApiServiceFactory implements Factory<OpenAIApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideOpenAIApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OpenAIApiService get() {
    return provideOpenAIApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideOpenAIApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideOpenAIApiServiceFactory(retrofitProvider);
  }

  public static OpenAIApiService provideOpenAIApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOpenAIApiService(retrofit));
  }
}
