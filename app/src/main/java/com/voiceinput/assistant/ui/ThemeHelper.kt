package com.voiceinput.assistant.ui

import android.content.Context
import androidx.core.content.ContextCompat
import com.voiceinput.assistant.R
import com.voiceinput.assistant.data.repository.ConfigurationManager

object ThemeHelper {
    
    data class ThemeColors(
        val background: Int,
        val surface: Int,
        val card: Int,
        val primary: Int,
        val accent: Int,
        val textPrimary: Int,
        val textSecondary: Int
    )
    
    fun getThemeColors(context: Context, theme: ConfigurationManager.AppTheme): ThemeColors {
        return when (theme) {
            ConfigurationManager.AppTheme.DARK_BLUE -> ThemeColors(
                background = ContextCompat.getColor(context, R.color.theme_blue_background),
                surface = ContextCompat.getColor(context, R.color.theme_blue_surface),
                card = ContextCompat.getColor(context, R.color.theme_blue_card),
                primary = ContextCompat.getColor(context, R.color.theme_blue_primary),
                accent = ContextCompat.getColor(context, R.color.theme_blue_accent),
                textPrimary = ContextCompat.getColor(context, R.color.white),
                textSecondary = ContextCompat.getColor(context, R.color.gray_300)
            )
            
            ConfigurationManager.AppTheme.AMOLED_BLACK -> ThemeColors(
                background = ContextCompat.getColor(context, R.color.black),
                surface = ContextCompat.getColor(context, R.color.black),
                card = ContextCompat.getColor(context, R.color.black),
                primary = ContextCompat.getColor(context, R.color.white),
                accent = ContextCompat.getColor(context, R.color.white),
                textPrimary = ContextCompat.getColor(context, R.color.white),
                textSecondary = ContextCompat.getColor(context, R.color.gray_300)
            )
            
            ConfigurationManager.AppTheme.DARK_GRAY -> ThemeColors(
                background = ContextCompat.getColor(context, R.color.theme_gray_background),
                surface = ContextCompat.getColor(context, R.color.theme_gray_surface),
                card = ContextCompat.getColor(context, R.color.theme_gray_card),
                primary = ContextCompat.getColor(context, R.color.white),
                accent = ContextCompat.getColor(context, R.color.white),
                textPrimary = ContextCompat.getColor(context, R.color.white),
                textSecondary = ContextCompat.getColor(context, R.color.gray_400) // Better contrast
            )
        }
    }
    
    fun getThemeDisplayName(theme: ConfigurationManager.AppTheme): String {
        return when (theme) {
            ConfigurationManager.AppTheme.DARK_BLUE -> "Dark Blue"
            ConfigurationManager.AppTheme.AMOLED_BLACK -> "AMOLED Black"
            ConfigurationManager.AppTheme.DARK_GRAY -> "Dark Gray"
        }
    }
} 