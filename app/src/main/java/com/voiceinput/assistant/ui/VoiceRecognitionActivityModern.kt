package com.voiceinput.assistant.ui

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.voiceinput.assistant.R
import com.voiceinput.assistant.data.model.TranscriptionResult
import com.voiceinput.assistant.viewmodels.MainViewModel
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.ui.ThemeHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.google.android.material.floatingactionbutton.FloatingActionButton

@AndroidEntryPoint
class VoiceRecognitionActivityModern : AppCompatActivity() {
    
    private val viewModel: MainViewModel by viewModels()
    
    @Inject
    lateinit var configManager: ConfigurationManager
    
    private lateinit var audioVisualizer: AudioVisualizerView
    private lateinit var btnCancel: FloatingActionButton
    private lateinit var statusText: TextView
    
    private var isRecording = false
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Apply theme (simplified for modern UI - always black background)
        // ThemeHelper.applyTheme(this, configManager.getSelectedTheme())
        
        // Make activity overlay with proper background dimming
        window.setFlags(
            WindowManager.LayoutParams.FLAG_DIM_BEHIND,
            WindowManager.LayoutParams.FLAG_DIM_BEHIND
        )
        window.attributes.dimAmount = 0.7f // Darken background
        
        setContentView(R.layout.activity_voice_recognition_modern)
        
        initializeViews()
        setupClickListeners()
        observeViewModel()
        
        // Auto-start recording if configured (with small delay to ensure UI is ready)
        if (viewModel.isConfigured()) {
            // Clear any previous transcription state first
            viewModel.clearTranscription()
            // Add small delay to ensure views are initialized
            audioVisualizer.postDelayed({
                startRecording()
            }, 100) // 100ms delay
        } else {
            showError("Please configure your AI model in Settings first")
        }
    }
    
    private fun initializeViews() {
        audioVisualizer = findViewById(R.id.audioVisualizer)
        btnCancel = findViewById(R.id.btnCancel)
        statusText = findViewById(R.id.statusText)
    }
    
    private fun setupClickListeners() {
        btnCancel.setOnClickListener {
            cancelRecording()
        }
        
        // Tap animation or anywhere on overlay to stop recording
        audioVisualizer.setOnClickListener {
            if (isRecording) {
                stopRecording()
            }
        }
        
        // Also allow tapping the main overlay to stop recording
        findViewById<View>(android.R.id.content).setOnClickListener {
            if (isRecording) {
                stopRecording()
            }
        }
    }
    
    private fun startRecording() {
        if (isRecording) return
        
        isRecording = true
        // viewModel.resetRecordingState() // Method doesn't exist in MainViewModel
        viewModel.startRecording()
        
        // Start audio visualizer animation
        audioVisualizer.startAnimation()
        
        // Hide status text for clean look
        statusText.visibility = View.GONE
        
        // Add subtle haptic feedback
        audioVisualizer.performHapticFeedback(android.view.HapticFeedbackConstants.VIRTUAL_KEY)
    }
    
    private fun stopRecording() {
        if (!isRecording) return
        
        isRecording = false
        viewModel.stopRecording()
        
        // Stop audio visualizer animation
        audioVisualizer.stopAnimation()
        
        // Show processing status
        statusText.text = "Processing..."
        statusText.visibility = View.VISIBLE
    }
    
    private fun cancelRecording() {
        if (isRecording) {
            viewModel.stopRecording()
            audioVisualizer.stopAnimation()
        }
        
        // Close activity without result
        setResult(Activity.RESULT_CANCELED)
        finish()
        
        // Add exit animation
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
    
    private fun showError(message: String) {
        statusText.text = message
        statusText.visibility = View.VISIBLE
        
        // Auto-close after showing error
        statusText.postDelayed({
            finish()
        }, 2000)
    }
    
    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.isRecording.collect { recording ->
                // Only update UI state, don't override our local isRecording flag
                if (!recording && isRecording) {
                    // Recording stopped by viewModel
                    isRecording = false
                    audioVisualizer.stopAnimation()
                }
            }
        }

        lifecycleScope.launch {
            viewModel.transcriptionState.collect { result ->
                when (result) {
                    is TranscriptionResult.Success -> {
                        isRecording = false
                        audioVisualizer.stopAnimation()
                        
                        if (result.text.isNotEmpty()) {
                            // Return result in proper voice input format
                            val resultIntent = Intent().apply {
                                putStringArrayListExtra(
                                    RecognizerIntent.EXTRA_RESULTS,
                                    arrayListOf(result.text)
                                )
                                putExtra("transcribed_text", result.text)
                            }
                            setResult(Activity.RESULT_OK, resultIntent)
                            
                            // Close immediately - no delay needed
                            finish()
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                        } else {
                            showError("No speech detected")
                        }
                    }
                    is TranscriptionResult.Error -> {
                        isRecording = false
                        audioVisualizer.stopAnimation()
                        showError("Error: ${result.message}")
                    }
                    is TranscriptionResult.Processing -> {
                        statusText.text = "Processing..."
                        statusText.visibility = View.VISIBLE
                    }
                    null -> {
                        // Initial state or cleared state - do nothing
                    }
                }
            }
        }
    }
    
    override fun onBackPressed() {
        cancelRecording()
        super.onBackPressed()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        if (::audioVisualizer.isInitialized) {
            audioVisualizer.stopAnimation()
        }
    }
}