package com.voiceinput.assistant.ui

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
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
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.AnimatorSet
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import android.graphics.drawable.GradientDrawable

@AndroidEntryPoint
class VoiceRecognitionActivity : AppCompatActivity() {
    
    private val viewModel: MainViewModel by viewModels()
    
    @Inject
    lateinit var configManager: ConfigurationManager
    
    private lateinit var statusText: TextView
    private lateinit var microphoneIcon: com.google.android.material.floatingactionbutton.FloatingActionButton
    private lateinit var stopButton: TextView
    private lateinit var cancelButton: TextView
    private lateinit var pulseRing: View
    private lateinit var pulseRingMiddle: View
    private lateinit var pulseRingOuter: View
    private lateinit var pulseCircle1: View
    private lateinit var pulseCircle2: View
    private lateinit var pulseCircle3: View
    private lateinit var pulseCircle4: View
    private lateinit var pulseCircle5: View
    private lateinit var pulseCircle6: View
    private lateinit var pulseCircle7: View
    private lateinit var pulseCircle8: View
    private lateinit var mainContainer: LinearLayout
    
    private var isRecording = false
    private var pulseAnimator: AnimatorSet? = null
    private var microphoneBreathingAnimator: ObjectAnimator? = null
    private var statusTextAnimator: ObjectAnimator? = null
    private var containerAnimator: ObjectAnimator? = null
    private var containerGlowAnimator: ObjectAnimator? = null
    private var isFirstLaunch = true // Track if this is a fresh launch
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // Configure as floating overlay with background dimming
            setupFloatingWindow()
            
            setContentView(R.layout.activity_voice_recognition)
            
            // CRITICAL FIX: Initialize views first and check for null
            if (!initializeViews()) {
                finish()
                return
            }
            
            setupClickListeners()
            
            // Apply theme after views are initialized - with error handling
            try {
                applyTheme()
            } catch (e: Exception) {
                // If theme application fails, continue without it
                statusText.text = "Tap microphone to start"
            }
            
            // Start fresh recording session for overlay - CRITICAL: Do this before observing
            viewModel.startFreshRecordingSession()
            
            // Set up observers AFTER clearing state
            observeViewModel()
            
            // Check if auto-start is enabled - with proper null checks
            try {
                if (::configManager.isInitialized && configManager.getAutoStartRecording()) {
                    // Auto-start recording with a small delay to ensure UI is ready
                    statusText.text = "Auto-starting recording..."
                    statusText.postDelayed({
                        if (!isDestroyed && !isFinishing) {
                            startVoiceRecording()
                        }
                    }, 100) // Small delay to ensure everything is initialized
                } else {
                    // Manual start
                    statusText.text = "Tap microphone to start"
                }
            } catch (e: Exception) {
                // Fallback if configManager fails
                statusText.text = "Tap microphone to start"
            }
        } catch (e: Exception) {
            // Handle any initialization errors gracefully
            try {
                statusText?.text = "Error initializing voice input"
            } catch (ignored: Exception) {
                // If even setting text fails, just finish
            }
            finish()
        }
    }
    
    private fun setupFloatingWindow() {
        // Make the activity appear as a floating overlay with proper touch handling
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        
        // CRITICAL: Remove any default window borders/decorations
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
        
        // Force window to be visible and on top
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        
        // Center the window on screen with proper size and ensure it's focusable for touch
        val params = window.attributes
        params.width = WindowManager.LayoutParams.WRAP_CONTENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        params.gravity = android.view.Gravity.CENTER
        params.flags = params.flags and WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE.inv() // Make focusable
        
        // CRITICAL: Enhanced background dimming for better focus
        params.dimAmount = 0.75f // Increased dimming (75%) to make voice overlay more prominent
        window.attributes = params
        
        // Add additional flags for better focus effect
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        
        // Ensure the window can receive touch events and has no borders
        window.setFlags(0, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        
        // CRITICAL: Remove any potential window frame/border
        window.decorView.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        window.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT))
    }
    
    private fun initializeViews(): Boolean {
        return try {
            statusText = findViewById(R.id.statusText) ?: return false
            microphoneIcon = findViewById(R.id.microphoneIcon) ?: return false
            stopButton = findViewById(R.id.stopButton) ?: return false
            cancelButton = findViewById(R.id.cancelButton) ?: return false
            pulseRing = findViewById(R.id.pulseRing) ?: return false
            pulseRingMiddle = findViewById(R.id.pulseRingMiddle) ?: return false
            pulseRingOuter = findViewById(R.id.pulseRingOuter) ?: return false
            pulseCircle1 = findViewById(R.id.pulseCircle1) ?: return false
            pulseCircle2 = findViewById(R.id.pulseCircle2) ?: return false
            pulseCircle3 = findViewById(R.id.pulseCircle3) ?: return false
            pulseCircle4 = findViewById(R.id.pulseCircle4) ?: return false
            pulseCircle5 = findViewById(R.id.pulseCircle5) ?: return false
            pulseCircle6 = findViewById(R.id.pulseCircle6) ?: return false
            pulseCircle7 = findViewById(R.id.pulseCircle7) ?: return false
            pulseCircle8 = findViewById(R.id.pulseCircle8) ?: return false
            mainContainer = findViewById(R.id.mainContainer) ?: return false
            true
        } catch (e: Exception) {
            false
        }
    }
    
    private fun setupClickListeners() {
        // Ensure all buttons are properly enabled and responsive
        stopButton.isEnabled = true
        cancelButton.isEnabled = true
        microphoneIcon.isEnabled = true
        
        stopButton.setOnClickListener {
            try {
                stopVoiceRecording()
            } catch (e: Exception) {
                statusText.text = "Error stopping recording"
            }
        }
        
        cancelButton.setOnClickListener {
            try {
                cancelVoiceRecording()
            } catch (e: Exception) {
                finish() // Fallback to just close the overlay
            }
        }
        
        microphoneIcon.setOnClickListener {
            try {
                // Check ViewModel state instead of local variable for more accurate state
                if (viewModel.isRecording.value) {
                    stopVoiceRecording()
                } else {
                    startVoiceRecording()
                }
            } catch (e: Exception) {
                statusText.text = "Error with microphone"
            }
        }
        
        // Add long click listener as backup
        microphoneIcon.setOnLongClickListener {
            try {
                if (viewModel.isRecording.value) {
                    cancelVoiceRecording()
                } else {
                    startVoiceRecording()
                }
                true
            } catch (e: Exception) {
                false
            }
        }
    }
    
    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.transcriptionState.collect { result ->
                when (result) {
                    is TranscriptionResult.Success -> {
                        // CRITICAL FIX: Only handle non-empty results from NEW recording sessions
                        // Skip any lingering results from previous sessions
                        if (result.text.isNotEmpty() && !isFirstLaunch) {
                            handleTranscriptionSuccess(result.text)
                        } else if (result.text.isEmpty()) {
                            // This is the cleared state - mark as no longer first launch
                            isFirstLaunch = false
                        }
                    }
                    is TranscriptionResult.Error -> {
                        if (!isFirstLaunch) { // Only handle errors from new sessions
                            handleTranscriptionError(result.message)
                        }
                    }
                    TranscriptionResult.Processing -> {
                        if (!isFirstLaunch) { // Only handle processing from new sessions
                            statusText.text = "Processing..."
                        }
                    }
                    null -> {
                        // Initial state or cleared state - do nothing
                    }
                }
            }
        }
        
        lifecycleScope.launch {
            viewModel.isRecording.collect { recording ->
                isRecording = recording
                updateUIForRecordingState(recording)
                
                // Mark as no longer first launch when recording starts
                if (recording) {
                    isFirstLaunch = false
                }
                
                // Ensure all buttons remain responsive
                microphoneIcon.isEnabled = true
                microphoneIcon.alpha = 1.0f
                stopButton.isEnabled = true
                cancelButton.isEnabled = true
                
                // Force a layout update to ensure buttons are clickable
                microphoneIcon.requestLayout()
            }
        }
    }
    
    private fun startVoiceRecording() {
        // Prevent multiple simultaneous starts
        if (viewModel.isRecording.value) {
            return
        }
        
        // Clear first launch flag when user explicitly starts recording
        isFirstLaunch = false
        
        statusText.text = "Listening..."
        microphoneIcon.isEnabled = false // Temporarily disable to prevent rapid clicks
        viewModel.startRecording()
        
        // Re-enable button after short delay
        statusText.postDelayed({
            microphoneIcon.isEnabled = true
        }, 500)
    }
    
    private fun stopVoiceRecording() {
        // Prevent multiple simultaneous stops
        if (!viewModel.isRecording.value) {
            return
        }
        
        statusText.text = "Processing..."
        microphoneIcon.isEnabled = false // Temporarily disable to prevent rapid clicks
        viewModel.stopRecording()
        
        // Re-enable button after short delay
        statusText.postDelayed({
            microphoneIcon.isEnabled = true
        }, 500)
    }
    
    private fun cancelVoiceRecording() {
        viewModel.stopRecording()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
    
    private fun updateUIForRecordingState(recording: Boolean) {
        try {
            if (recording) {
                microphoneIcon.setImageResource(R.drawable.ic_stop)
                stopButton.visibility = View.VISIBLE
                statusText.text = "Recording... Tap to stop"
                startPulseAnimation()
            } else {
                microphoneIcon.setImageResource(R.drawable.ic_microphone)
                stopButton.visibility = View.GONE
                stopPulseAnimation()
                // Only update status text if it's not showing processing or error messages
                if (!statusText.text.toString().contains("Processing") && 
                    !statusText.text.toString().contains("Error") &&
                    !statusText.text.toString().contains("Auto-starting")) {
                    statusText.text = "Tap microphone to start"
                }
            }
        } catch (e: Exception) {
            // If UI update fails, at least update the basic state
            try {
                statusText.text = if (recording) "Recording..." else "Tap microphone to start"
            } catch (ignored: Exception) {
                // Even this can fail, so just continue
            }
        }
    }
    
    private fun applyTheme() {
        try {
            // Use default theme if configManager is not initialized
            val currentTheme = if (::configManager.isInitialized) {
                try {
                    configManager.getAppTheme()
                } catch (e: Exception) {
                    ConfigurationManager.AppTheme.AMOLED_BLACK
                }
            } else {
                ConfigurationManager.AppTheme.AMOLED_BLACK
            }
            val themeColors = ThemeHelper.getThemeColors(this, currentTheme)
        
            // Apply theme-specific rounded background with borders
            try {
                val backgroundDrawable = when (currentTheme) {
                    ConfigurationManager.AppTheme.DARK_BLUE -> ContextCompat.getDrawable(this, R.drawable.rounded_container_dark_blue)
                    ConfigurationManager.AppTheme.DARK_GRAY -> ContextCompat.getDrawable(this, R.drawable.rounded_container_dark_gray)
                    ConfigurationManager.AppTheme.AMOLED_BLACK -> ContextCompat.getDrawable(this, R.drawable.rounded_container_amoled_black)
                }
                mainContainer.background = backgroundDrawable
                statusText.setTextColor(themeColors.textPrimary)
            } catch (e: Exception) {
                // Fallback to basic rounded background if theme application fails
                try {
                    mainContainer.background = ContextCompat.getDrawable(this, R.drawable.rounded_container_amoled_black)
                    statusText.setTextColor(android.graphics.Color.WHITE)
                } catch (fallbackError: Exception) {
                    // Ultimate fallback - solid color with rounded corners
                    mainContainer.setBackgroundColor(android.graphics.Color.BLACK)
                    statusText.setTextColor(android.graphics.Color.WHITE)
                }
            }
            
            // Apply simple microphone styling - avoid complex theme logic
            try {
                microphoneIcon.backgroundTintList = ColorStateList.valueOf(android.graphics.Color.WHITE)
                microphoneIcon.imageTintList = ColorStateList.valueOf(android.graphics.Color.BLACK)
            } catch (e: Exception) {
                // If tinting fails, just leave default
            }
            
            // Apply theme-specific button styling with rounded backgrounds
            try {
                when (currentTheme) {
                    ConfigurationManager.AppTheme.AMOLED_BLACK -> {
                        stopButton.setTextColor(android.graphics.Color.WHITE)
                        cancelButton.setTextColor(android.graphics.Color.GRAY)
                    }
                    ConfigurationManager.AppTheme.DARK_GRAY -> {
                        stopButton.setTextColor(android.graphics.Color.WHITE)
                        cancelButton.setTextColor(android.graphics.Color.LTGRAY)
                    }
                    ConfigurationManager.AppTheme.DARK_BLUE -> {
                        stopButton.setTextColor(themeColors.accent)
                        cancelButton.setTextColor(themeColors.textSecondary)
                    }
                }
            } catch (e: Exception) {
                // Fallback button styling
                try {
                    stopButton.setTextColor(android.graphics.Color.WHITE)
                    cancelButton.setTextColor(android.graphics.Color.WHITE)
                } catch (fallbackError: Exception) {
                    // If even fallback fails, just continue
                }
            }
            
            // CRITICAL: Update window background to be completely transparent for the overlay content
            // The background dimming is handled by FLAG_DIM_BEHIND in setupFloatingWindow()
            try {
                window.decorView.setBackgroundColor(android.graphics.Color.TRANSPARENT)
                window.setBackgroundDrawable(android.graphics.drawable.ColorDrawable(android.graphics.Color.TRANSPARENT))
            } catch (e: Exception) {
                // If window styling fails, continue anyway
            }
            
        } catch (e: Exception) {
            // If entire theme application fails, just continue with defaults
            try {
                statusText.text = "Theme error - using defaults"
            } catch (ignored: Exception) {
                // Even this can fail, so just continue
            }
        }
    }
    
    override fun onStart() {
        super.onStart()
        // Ensure window is properly visible when starting
        window.decorView.visibility = View.VISIBLE
        
        // Don't reset recording state here - let the ViewModel manage it
        // This was interfering with auto-start functionality
    }
    
    override fun onResume() {
        super.onResume()
        // Reapply theme when returning to overlay
        applyTheme()
        
        // Ensure overlay is visible
        window.decorView.visibility = View.VISIBLE
        window.decorView.alpha = 1.0f
        
        // Don't override status text here - let the ViewModel and auto-start logic handle it
        // This was causing issues with auto-start functionality
    }
    
    override fun onPause() {
        super.onPause()
        // Stop any ongoing animations
        stopPulseAnimation()
    }
    
    private fun startPulseAnimation() {
        try {
            // Show all pulse circles
            val pulseCircles = listOf(pulseCircle1, pulseCircle2, pulseCircle3, pulseCircle4, 
                                    pulseCircle5, pulseCircle6, pulseCircle7, pulseCircle8)
            pulseCircles.forEach { it.visibility = View.VISIBLE }
            pulseRing.visibility = View.GONE
            pulseRingMiddle.visibility = View.GONE
            pulseRingOuter.visibility = View.GONE
            
            // Stop any existing animations first
            stopPulseAnimation()
            
            // Create sequential pulsing animation for each circle
            val animators = mutableListOf<ObjectAnimator>()
            
            pulseCircles.forEachIndexed { index, circle ->
                val animator = ObjectAnimator.ofFloat(circle, "scaleX", 1.0f, 3.0f).apply {
                    duration = 600
                    repeatCount = ValueAnimator.INFINITE
                    repeatMode = ValueAnimator.RESTART
                    interpolator = AccelerateDecelerateInterpolator()
                    startDelay = (index * 150).toLong() // Stagger each circle by 150ms for better visibility
                    
                    addUpdateListener { animation ->
                        try {
                            val scale = animation.animatedValue as Float
                            circle.scaleY = scale
                            // More dramatic fade out as it grows
                            circle.alpha = 1.0f - ((scale - 1.0f) / 2.0f)
                        } catch (e: Exception) {
                            // Ignore animation update errors
                        }
                    }
                }
                animators.add(animator)
            }
            
            
            // Gentle microphone breathing animation
            microphoneBreathingAnimator = ObjectAnimator.ofFloat(microphoneIcon, "scaleX", 1.0f, 1.08f).apply {
                duration = 1200
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
                interpolator = AccelerateDecelerateInterpolator()
                
                addUpdateListener { animation ->
                    try {
                        val scale = animation.animatedValue as Float
                        microphoneIcon.scaleY = scale
                        // Remove rotation - keep it simple
                    } catch (e: Exception) {
                        // Ignore animation update errors
                    }
                }
            }
            
            // Start all circle animations together
            pulseAnimator = AnimatorSet().apply {
                playTogether(animators as Collection<android.animation.Animator>)
                start()
            }
            
            microphoneBreathingAnimator?.start()
            
        } catch (e: Exception) {
            // If animation fails, just hide the pulse rings
            try {
                pulseRing.visibility = View.GONE
                pulseRingMiddle.visibility = View.GONE
                pulseRingOuter.visibility = View.GONE
            } catch (ignored: Exception) {
                // Even this can fail
            }
        }
    }
    
    private fun stopPulseAnimation() {
        try {
            pulseAnimator?.cancel()
            pulseAnimator = null
            microphoneBreathingAnimator?.cancel()
            microphoneBreathingAnimator = null
            // Hide all pulse elements
            pulseRing.visibility = View.GONE
            pulseRingMiddle.visibility = View.GONE
            pulseRingOuter.visibility = View.GONE
            pulseCircle1.visibility = View.GONE
            pulseCircle2.visibility = View.GONE
            pulseCircle3.visibility = View.GONE
            pulseCircle4.visibility = View.GONE
            pulseCircle5.visibility = View.GONE
            pulseCircle6.visibility = View.GONE
            pulseCircle7.visibility = View.GONE
            pulseCircle8.visibility = View.GONE
            
            // Reset microphone to default state
            microphoneIcon.scaleX = 1f
            microphoneIcon.scaleY = 1f
        } catch (e: Exception) {
            // Ignore animation cleanup errors
        }
    }
    
    private fun handleTranscriptionSuccess(text: String) {
        statusText.text = "Transcribed: $text"
        
        // Only return result if we were called as speech recognition activity
        // This prevents auto-pasting when launched from floating button
        if (intent.action == RecognizerIntent.ACTION_RECOGNIZE_SPEECH) {
            val resultIntent = Intent().apply {
                putStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS,
                    arrayListOf(text)
                )
                putExtra(
                    RecognizerIntent.EXTRA_CONFIDENCE_SCORES,
                    floatArrayOf(0.95f)
                )
            }
            setResult(Activity.RESULT_OK, resultIntent)
        } else {
            // For floating button launches, just copy to clipboard instead
            try {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Voice Input", text)
                clipboard.setPrimaryClip(clip)
                statusText.text = "Copied to clipboard: $text"
            } catch (e: Exception) {
                statusText.text = "Transcribed: $text"
            }
        }
        
        // Use configured delay or finish immediately
        val delay = if (::configManager.isInitialized) {
            configManager.getTranscriptionDelay()
        } else {
            2000 // Default 2 seconds
        }
        if (delay > 0) {
            // Show result for configured time, then auto-finish
            statusText.postDelayed({
                finish()
            }, delay.toLong())
        } else {
            // Immediate finish - no delay
            finish()
        }
    }
    
    private fun handleTranscriptionError(error: String) {
        statusText.text = "Error: $error"
        
        val resultIntent = Intent().apply {
            putExtra("android.speech.extra.ERROR_CODE", SpeechRecognizer.ERROR_AUDIO)
        }
        
        setResult(Activity.RESULT_CANCELED, resultIntent)
        
        // Delay finish to show the error briefly
        statusText.postDelayed({
            finish()
        }, 2000)
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        cancelVoiceRecording()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        stopPulseAnimation()
        if (isRecording) {
            viewModel.stopRecording()
        }
    }
} 