package com.voiceinput.assistant.data.audio;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AudioRecorder_Factory implements Factory<AudioRecorder> {
  private final Provider<Context> contextProvider;

  public AudioRecorder_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AudioRecorder get() {
    return newInstance(contextProvider.get());
  }

  public static AudioRecorder_Factory create(Provider<Context> contextProvider) {
    return new AudioRecorder_Factory(contextProvider);
  }

  public static AudioRecorder newInstance(Context context) {
    return new AudioRecorder(context);
  }
}
