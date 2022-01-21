package com.migascl.musicyou.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightThemeColors = lightColorScheme(

)

private val DarkThemeColors = darkColorScheme(

)

@Composable
fun MusicYouTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    val useDynamicColor = true

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
        val colors = if (!darkTheme) {
            if (useDynamicColor) {
                dynamicDarkColorScheme(LocalContext.current)
            } else {
                DarkThemeColors
            }
        } else {
            if (useDynamicColor) {
                dynamicLightColorScheme(LocalContext.current)
            } else {
                LightThemeColors
            }
        }

        MaterialTheme(
            colorScheme = colors,
            typography = appTypography,
            content = content
        )
    }

}