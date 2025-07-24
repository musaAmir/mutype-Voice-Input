package com.voiceinput.assistant.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/voiceinput/assistant/ui/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "apiKeyEditText", "Landroid/widget/EditText;", "configManager", "Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "getConfigManager", "()Lcom/voiceinput/assistant/data/repository/ConfigurationManager;", "setConfigManager", "(Lcom/voiceinput/assistant/data/repository/ConfigurationManager;)V", "languageSpinner", "Landroid/widget/Spinner;", "modelSpinner", "saveButton", "Landroid/widget/Button;", "temperatureSeekBar", "Landroid/widget/SeekBar;", "testButton", "viewModel", "Lcom/voiceinput/assistant/viewmodels/SettingsViewModel;", "getViewModel", "()Lcom/voiceinput/assistant/viewmodels/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupListeners", "updateUI", "state", "Lcom/voiceinput/assistant/viewmodels/SettingsUiState;", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class SettingsActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.voiceinput.assistant.data.repository.ConfigurationManager configManager;
    private android.widget.Spinner modelSpinner;
    private android.widget.Spinner languageSpinner;
    private android.widget.EditText apiKeyEditText;
    private android.widget.SeekBar temperatureSeekBar;
    private android.widget.Button saveButton;
    private android.widget.Button testButton;
    
    public SettingsActivity() {
        super();
    }
    
    private final com.voiceinput.assistant.viewmodels.SettingsViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.voiceinput.assistant.data.repository.ConfigurationManager getConfigManager() {
        return null;
    }
    
    public final void setConfigManager(@org.jetbrains.annotations.NotNull
    com.voiceinput.assistant.data.repository.ConfigurationManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupListeners() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateUI(com.voiceinput.assistant.viewmodels.SettingsUiState state) {
    }
}