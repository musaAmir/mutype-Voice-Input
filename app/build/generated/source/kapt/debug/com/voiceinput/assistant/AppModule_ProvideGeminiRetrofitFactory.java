package com.voiceinput.assistant;

import com.google.gson.Gson;
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
public final class AppModule_ProvideGeminiRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Gson> gsonProvider;

  public AppModule_ProvideGeminiRetrofitFactory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideGeminiRetrofit(gsonProvider.get());
  }

  public static AppModule_ProvideGeminiRetrofitFactory create(Provider<Gson> gsonProvider) {
    return new AppModule_ProvideGeminiRetrofitFactory(gsonProvider);
  }

  public static Retrofit provideGeminiRetrofit(Gson gson) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideGeminiRetrofit(gson));
  }
}
