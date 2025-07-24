package com.voiceinput.assistant.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.provider.Settings
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.voiceinput.assistant.R
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.ui.VoiceRecognitionActivity
import com.voiceinput.assistant.ui.VoiceRecognitionActivityModern
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FloatingVoiceService : Service() {
    
    @Inject
    lateinit var configManager: ConfigurationManager
    
    private var windowManager: WindowManager? = null
    private var floatingView: View? = null
    private var floatingButton: FloatingActionButton? = null
    
    // Variables for drag functionality
    private var initialX = 0
    private var initialY = 0
    private var initialTouchX = 0f
    private var initialTouchY = 0f
    
    override fun onCreate() {
        super.onCreate()
        
        // Check if we have overlay permission
        if (!Settings.canDrawOverlays(this)) {
            // Cannot create overlay without permission
            stopSelf()
            return
        }
        
        createFloatingButton()
    }
    
    private fun createFloatingButton() {
        try {
            windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
            
            // Inflate the floating view
            floatingView = LayoutInflater.from(this).inflate(R.layout.floating_voice_button, null)
            floatingButton = floatingView?.findViewById(R.id.floating_microphone_button)
            
            // REMOVED: Click listener - now handled by touch listener to prevent conflicts
            // The setupDragFunctionality() method handles both clicking and dragging
            
            // Make button responsive for touch events
            floatingButton?.isClickable = false // Disable default click to prevent conflicts
            floatingButton?.isFocusable = true
            
            // Set up drag functionality with integrated click handling
            setupDragFunctionality()
            
            // Configure window parameters - make it focusable to capture touch events properly
            val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT
            )
            
            // Position the button on the screen (default to right side)
            params.x = 100
            params.y = 100
            
            // Add the view to window manager
            windowManager?.addView(floatingView, params)
            
        } catch (e: Exception) {
            Toast.makeText(this, "Error creating floating button: ${e.message}", Toast.LENGTH_SHORT).show()
            stopSelf()
        }
    }
    
    private fun setupDragFunctionality() {
        // FIXED: Improved touch handling to eliminate double-tap requirement
        floatingView?.setOnTouchListener { view, event ->
            val params = view.layoutParams as? WindowManager.LayoutParams
            
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Store initial position for potential drag
                    initialX = params?.x ?: 0
                    initialY = params?.y ?: 0
                    initialTouchX = event.rawX
                    initialTouchY = event.rawY
                    true // Consume down events to ensure we get subsequent events
                }
                MotionEvent.ACTION_MOVE -> {
                    // Check if user is dragging or just clicking
                    val deltaX = Math.abs(event.rawX - initialTouchX)
                    val deltaY = Math.abs(event.rawY - initialTouchY)
                    
                    if (deltaX > 15 || deltaY > 15) {
                        // User is dragging - update position
                        params?.let {
                            it.x = initialX + (event.rawX - initialTouchX).toInt()
                            it.y = initialY + (event.rawY - initialTouchY).toInt()
                            windowManager?.updateViewLayout(view, it)
                        }
                    }
                    true // Always consume move events during potential drag
                }
                MotionEvent.ACTION_UP -> {
                    // Check if it was just a small movement (click)
                    val deltaX = Math.abs(event.rawX - initialTouchX)
                    val deltaY = Math.abs(event.rawY - initialTouchY)
                    
                    if (deltaX < 15 && deltaY < 15) {
                        // It was a click - immediately trigger voice recognition
                        floatingButton?.performHapticFeedback(android.view.HapticFeedbackConstants.VIRTUAL_KEY)
                        startVoiceRecognition()
                        return@setOnTouchListener true // Consume the event
                    }
                    true // Consume up events to prevent conflicts
                }
                else -> false
            }
        }
        
        // REMOVED: Conflicting click listener on button itself to prevent double-handling
        // The touch listener above handles both clicking and dragging
    }
    
    private fun startVoiceRecognition() {
        try {
            val intent = Intent(this, VoiceRecognitionActivityModern::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or 
                       Intent.FLAG_ACTIVITY_CLEAR_TOP or
                       Intent.FLAG_ACTIVITY_SINGLE_TOP
                // Add extra to indicate this is from floating button
                putExtra("from_floating_button", true)
            }
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Error starting voice recognition: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY // Keep service running
    }
    
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    
    override fun onDestroy() {
        super.onDestroy()
        try {
            if (floatingView != null) {
                windowManager?.removeView(floatingView)
                floatingView = null
            }
        } catch (e: Exception) {
            // Ignore errors during cleanup
        }
    }
}