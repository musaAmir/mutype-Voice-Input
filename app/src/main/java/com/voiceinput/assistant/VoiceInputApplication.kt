package com.voiceinput.assistant

import android.app.Application
import android.content.Intent
import android.provider.Settings
import com.google.gson.Gson
import com.voiceinput.assistant.data.network.OpenAIApiService
import com.voiceinput.assistant.data.network.GroqApiService
import com.voiceinput.assistant.data.network.GeminiApiService
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.services.FloatingVoiceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@HiltAndroidApp
class VoiceInputApplication : Application() {
    
    @Inject
    lateinit var configManager: ConfigurationManager
    
    override fun onCreate() {
        super.onCreate()
        instance = this
        
        // Auto-start floating service if it was previously enabled and we have permission
        try {
            // Add a small delay to ensure all dependencies are initialized
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                try {
                    if (::configManager.isInitialized && 
                        configManager.getFloatingButtonEnabled() && 
                        Settings.canDrawOverlays(this)) {
                        val serviceIntent = Intent(this, FloatingVoiceService::class.java)
                        startService(serviceIntent)
                    }
                } catch (e: Exception) {
                    // Ignore errors during auto-start - user can manually enable in settings
                }
            }, 1000) // 1 second delay
        } catch (e: Exception) {
            // Ignore errors during auto-start - user can manually enable in settings
        }
    }
    
    companion object {
        lateinit var instance: VoiceInputApplication
            private set
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenAIApiService(retrofit: Retrofit): OpenAIApiService {
        return retrofit.create(OpenAIApiService::class.java)
    }

    @Provides
    @Singleton
    @Named("groq")
    fun provideGroqRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.groq.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGroqApiService(@Named("groq") retrofit: Retrofit): GroqApiService {
        return retrofit.create(GroqApiService::class.java)
    }

    @Provides
    @Singleton
    @Named("gemini")
    fun provideGeminiRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://speech.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideGeminiApiService(@Named("gemini") retrofit: Retrofit): GeminiApiService {
        return retrofit.create(GeminiApiService::class.java)
    }
}