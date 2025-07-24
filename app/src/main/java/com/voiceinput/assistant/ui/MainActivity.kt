package com.voiceinput.assistant.ui

import android.Manifest
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.voiceinput.assistant.R
import com.voiceinput.assistant.data.model.TranscriptionResult
import com.voiceinput.assistant.databinding.ActivityMainBinding
import com.voiceinput.assistant.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        // Update configuration display when returning from settings
        updateConfigDisplay()
    }

    private fun setupClickListeners() {
        binding.btnMicrophone.setOnClickListener {
            requestAudioPermission()
        }
        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        
        // Implement copy button
        binding.btnCopy.setOnClickListener {
            copyTranscribedText()
        }
        
        // Implement clear button
        binding.btnClear.setOnClickListener {
            clearTranscribedText()
        }
    }
    
    private fun copyTranscribedText() {
        val transcribedText = binding.tvTranscribedText.text.toString()
        if (transcribedText.isNotEmpty()) {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Transcribed Text", transcribedText)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No text to copy", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun clearTranscribedText() {
        viewModel.clearTranscription()
        binding.tvTranscribedText.text = ""
        binding.layoutTranscription.visibility = View.GONE
        binding.tvStatus.text = if (viewModel.isConfigured()) "Tap microphone to start" else "Configure your AI model in Settings to get started"
        Toast.makeText(this, "Text cleared", Toast.LENGTH_SHORT).show()
    }

    private fun requestAudioPermission() {
        Dexter.withContext(this)
            .withPermissions(Manifest.permission.RECORD_AUDIO)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    report?.let {
                        if (it.areAllPermissionsGranted()) {
                            viewModel.onPermissionsGranted()
                            toggleRecording()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }
            }).check()
    }

    private fun toggleRecording() {
        if (viewModel.isRecording.value) {
            viewModel.stopRecording()
        } else {
            // Launch voice recognition as proper voice input
            val intent = Intent(android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL, 
                        android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(android.speech.RecognizerIntent.EXTRA_PROMPT, "Speak now...")
            }
            
            // Check if our modern activity can handle this intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE)
            } else {
                // Fallback to direct launch
                val fallbackIntent = Intent(this, VoiceRecognitionActivityModern::class.java)
                startActivity(fallbackIntent)
            }
        }
    }
    
    companion object {
        private const val VOICE_RECOGNITION_REQUEST_CODE = 1001
    }
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val results = data?.getStringArrayListExtra(android.speech.RecognizerIntent.EXTRA_RESULTS)
            val transcribedText = results?.firstOrNull() ?: data?.getStringExtra("transcribed_text")
            
            if (!transcribedText.isNullOrEmpty()) {
                binding.tvTranscribedText.text = transcribedText
                binding.layoutTranscription.visibility = View.VISIBLE
                binding.tvStatus.text = "Transcription complete. Tap microphone to record again."
            }
        }
    }

    private fun updateConfigDisplay() {
        binding.tvCurrentConfig.text = viewModel.getCurrentModelDisplay()
        // Update initial status based on configuration
        if (!viewModel.isRecording.value) {
            binding.tvStatus.text = if (viewModel.isConfigured()) "Tap microphone to start" else "Configure your AI model in Settings to get started"
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.isRecording.collectLatest { isRecording ->
                if (isRecording) {
                    binding.btnMicrophone.setImageResource(R.drawable.ic_stop)
                    binding.tvStatus.text = "Recording..."
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.btnMicrophone.setImageResource(R.drawable.ic_microphone)
                    // Don't automatically set status here - let transcription state handle it
                }
            }
        }

        lifecycleScope.launch {
            viewModel.transcriptionState.collect { result ->
                when (result) {
                    is TranscriptionResult.Success -> {
                        binding.progressBar.visibility = View.GONE
                        if (result.text.isNotEmpty()) {
                            binding.tvTranscribedText.text = result.text
                            binding.layoutTranscription.visibility = View.VISIBLE
                            binding.tvStatus.text = "Transcription complete. Tap microphone to record again."
                        } else {
                            binding.tvStatus.text = "No speech detected. Tap microphone to try again."
                        }
                    }
                    is TranscriptionResult.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvStatus.text = "Error: ${result.message}"
                    }
                    is TranscriptionResult.Processing -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.tvStatus.text = "Processing..."
                    }
                    null -> {
                        // Initial state or cleared state - do nothing
                    }
                }
            }
        }

        // Initial configuration display
        updateConfigDisplay()
    }
}