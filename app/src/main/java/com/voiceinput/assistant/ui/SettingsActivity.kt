package com.voiceinput.assistant.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.voiceinput.assistant.data.repository.ConfigurationManager
import com.voiceinput.assistant.viewmodels.SettingsViewModel
import com.voiceinput.assistant.viewmodels.SettingsUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {

    private val viewModel: SettingsViewModel by viewModels()

    @Inject
    lateinit var configManager: ConfigurationManager

    private lateinit var modelSpinner: Spinner
    private lateinit var languageSpinner: Spinner
    private lateinit var apiKeyEditText: EditText
    private lateinit var temperatureSeekBar: SeekBar
    private lateinit var saveButton: Button
    private lateinit var testButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Create clean scrollable layout
        val scrollView = ScrollView(this)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
        }
        scrollView.addView(layout)

        // Title
        val title = TextView(this).apply {
            text = "Voice Input Settings"
            textSize = 24f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 0, 0, 48)
            gravity = android.view.Gravity.CENTER
        }
        layout.addView(title)
        
        // Add section divider
        val divider1 = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                2
            ).apply { setMargins(0, 0, 0, 32) }
            setBackgroundColor(android.graphics.Color.GRAY)
        }
        layout.addView(divider1)

        // AI Configuration Section
        val aiSectionTitle = TextView(this).apply {
            text = "AI Configuration"
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 0, 0, 16)
        }
        layout.addView(aiSectionTitle)
        
        // Model selection
        val modelLabel = TextView(this).apply { 
            text = "AI Model:"
            textSize = 14f
            setPadding(0, 8, 0, 8)
        }
        layout.addView(modelLabel)
        
        modelSpinner = Spinner(this).apply {
            val adapter = ArrayAdapter(
                this@SettingsActivity,
                android.R.layout.simple_spinner_item,
                viewModel.getModelDisplayNames()
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            this.adapter = adapter
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 16) }
        }
        layout.addView(modelSpinner)

        // API Key
        val apiKeyLabel = TextView(this).apply { 
            text = "API Key:"
            textSize = 14f
            setPadding(0, 16, 0, 8)
        }
        layout.addView(apiKeyLabel)
        
        apiKeyEditText = EditText(this).apply {
            hint = "Enter your API key (sk-... or gsk-...)"
            inputType = android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 16) }
            setPadding(16, 16, 16, 16)
        }
        layout.addView(apiKeyEditText)

        // Language
        val languageLabel = TextView(this).apply { 
            text = "Language:"
            textSize = 14f
            setPadding(0, 24, 0, 8)
        }
        layout.addView(languageLabel)
        
        languageSpinner = Spinner(this).apply {
            val adapter = ArrayAdapter(
                this@SettingsActivity,
                android.R.layout.simple_spinner_item,
                viewModel.getLanguageDisplayNames()
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            this.adapter = adapter
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 16) }
        }
        layout.addView(languageSpinner)

        // Temperature
        val tempLabel = TextView(this).apply { 
            text = "Temperature: 0.3"
            textSize = 14f
            setPadding(0, 24, 0, 8)
        }
        layout.addView(tempLabel)
        
        temperatureSeekBar = SeekBar(this).apply {
            max = 100
            progress = 30
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 32) }
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    tempLabel.text = "Temperature: ${progress / 100f}"
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })
        }
        layout.addView(temperatureSeekBar)

        // Theme Selection Section
        val themeSectionTitle = TextView(this).apply {
            text = "Appearance"
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 16, 0, 16)
        }
        layout.addView(themeSectionTitle)

        // Theme Selection
        val themeLabel = TextView(this).apply { 
            text = "App Theme:"
            textSize = 14f
            setPadding(0, 8, 0, 8)
        }
        layout.addView(themeLabel)
        
        val themeSpinner = Spinner(this).apply {
            val adapter = ArrayAdapter(
                this@SettingsActivity,
                android.R.layout.simple_spinner_item,
                listOf("AMOLED Black", "Dark Gray", "Dark Blue")
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            this.adapter = adapter
            
            // Fix theme mapping - get current theme and map correctly
            val currentTheme = configManager.getAppTheme()
            val themeIndex = when (currentTheme) {
                ConfigurationManager.AppTheme.AMOLED_BLACK -> 0
                ConfigurationManager.AppTheme.DARK_GRAY -> 1
                ConfigurationManager.AppTheme.DARK_BLUE -> 2
            }
            setSelection(themeIndex)
            
            onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                    val selectedTheme = when (position) {
                        0 -> ConfigurationManager.AppTheme.AMOLED_BLACK
                        1 -> ConfigurationManager.AppTheme.DARK_GRAY
                        2 -> ConfigurationManager.AppTheme.DARK_BLUE
                        else -> ConfigurationManager.AppTheme.AMOLED_BLACK
                    }
                    configManager.setAppTheme(selectedTheme)
                }
                override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
            }
            
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 24) }
        }
        layout.addView(themeSpinner)

        // Behavior Section
        val behaviorSectionTitle = TextView(this).apply {
            text = "Recording Behavior"
            textSize = 18f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 16, 0, 16)
        }
        layout.addView(behaviorSectionTitle)

        // Auto-start Recording Toggle
        val autoStartToggle = CheckBox(this).apply {
            text = "Auto-start recording when overlay opens"
            textSize = 14f
            isChecked = configManager.getAutoStartRecording()
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 8, 0, 16) }
            setOnCheckedChangeListener { _, isChecked ->
                configManager.setAutoStartRecording(isChecked)
            }
        }
        layout.addView(autoStartToggle)

        // Transcription Delay
        val delayLabel = TextView(this).apply { 
            text = "Transcription Display Duration: ${configManager.getTranscriptionDelay()}ms"
            textSize = 14f
            setPadding(0, 16, 0, 8)
        }
        layout.addView(delayLabel)
        
        val delaySeekBar = SeekBar(this).apply {
            max = 5000
            progress = configManager.getTranscriptionDelay()
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 16) }
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    delayLabel.text = "Transcription Display Duration: ${progress}ms"
                    configManager.setTranscriptionDelay(progress)
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })
        }
        layout.addView(delaySeekBar)

        // Floating Button Toggle
        val floatingToggle = CheckBox(this).apply {
            text = "Enable system-wide floating voice button"
            textSize = 14f
            isChecked = configManager.getFloatingButtonEnabled()
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 16, 0, 24) }
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && !android.provider.Settings.canDrawOverlays(this@SettingsActivity)) {
                    // Request overlay permission
                    val intent = android.content.Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                    intent.data = android.net.Uri.parse("package:${this@SettingsActivity.packageName}")
                    startActivity(intent)
                    this.isChecked = false
                } else {
                    configManager.setFloatingButtonEnabled(isChecked)
                }
            }
        }
        layout.addView(floatingToggle)

        // Add final section divider
        val divider2 = View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                2
            ).apply { setMargins(0, 32, 0, 32) }
            setBackgroundColor(android.graphics.Color.GRAY)
        }
        layout.addView(divider2)

        // Buttons - properly aligned
        val buttonLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, 16, 0, 32)
        }

        testButton = Button(this).apply {
            text = "Test Connection"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 0, 16) }
            setOnClickListener {
                lifecycleScope.launch {
                    viewModel.testConnection()
                }
            }
        }
        buttonLayout.addView(testButton)

        saveButton = Button(this).apply {
            text = "Save Settings"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setOnClickListener {
                lifecycleScope.launch {
                    viewModel.saveSettings(
                        selectedModelIndex = modelSpinner.selectedItemPosition,
                        apiKey = apiKeyEditText.text.toString(),
                        selectedLanguageIndex = languageSpinner.selectedItemPosition,
                        temperature = temperatureSeekBar.progress / 100f
                    )
                }
            }
        }
        buttonLayout.addView(saveButton)

        layout.addView(buttonLayout)
        setContentView(scrollView)

        setupListeners()
        observeViewModel()
    }

    private fun setupListeners() {
        apiKeyEditText.doOnTextChanged { text, _, _, _ ->
            viewModel.updateApiKey(text.toString())
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                updateUI(state)
            }
        }

        lifecycleScope.launch {
            viewModel.events.collect { event ->
                when (event) {
                    is SettingsViewModel.Event.SettingsSaved -> {
                        Toast.makeText(this@SettingsActivity, "Settings saved successfully!", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    else -> {
                        Toast.makeText(this@SettingsActivity, "Connection test completed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun updateUI(state: SettingsUiState) {
        modelSpinner.setSelection(state.selectedModelIndex)
        languageSpinner.setSelection(state.selectedLanguageIndex)
        temperatureSeekBar.progress = (state.temperature * 100).toInt()

        if (apiKeyEditText.text.toString() != state.apiKey) {
            apiKeyEditText.setText(state.apiKey)
        }

        saveButton.isEnabled = state.canTestConnection
        testButton.isEnabled = state.canTestConnection
    }
}