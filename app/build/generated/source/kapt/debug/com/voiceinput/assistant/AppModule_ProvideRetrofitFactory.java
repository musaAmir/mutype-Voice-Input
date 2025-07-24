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
public final class AppModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Gson> gsonProvider;

  public AppModule_ProvideRetrofitFactory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(gsonProvider.get());
  }

  public static AppModule_ProvideRetrofitFactory create(Provider<Gson> gsonProvider) {
    return new AppModule_ProvideRetrofitFactory(gsonProvider);
  }

  public static Retrofit provideRetrofit(Gson gson) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRetrofit(gson));
  }
}
