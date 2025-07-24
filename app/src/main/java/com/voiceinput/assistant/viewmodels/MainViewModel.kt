package com.voiceinput.assistant.viewmodels

import androidx.lifecycle.ViewModel
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.data.repository.VoiceInputRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: VoiceInputRepository,
    private val configManager: ConfigurationManager
) : ViewModel() {

    val transcriptionState = repository.transcriptionState

    val isRecording = MutableStateFlow(false)

    fun startRecording() {
        isRecording.value = true
        repository.startRecording()
    }

    fun stopRecording() {
        isRecording.value = false
        repository.stopRecording()
    }

    fun clearTranscription() {
        repository.clearTranscription()
    }

    fun startFreshRecordingSession() {
        // Reset any previous state for a clean recording session
        repository.resetRecordingState()
        isRecording.value = false
    }

    fun onPermissionsGranted() {
        // can be used to trigger something once permissions are granted
    }

    fun getCurrentModelDisplay(): String {
        val config = configManager.getCurrentConfig()
        return if (config != null) {
            "Model: ${config.model.displayName}"
        } else {
            "No model configured."
        }
    }

    fun isConfigured(): Boolean {
        return configManager.isConfigured()
    }
}