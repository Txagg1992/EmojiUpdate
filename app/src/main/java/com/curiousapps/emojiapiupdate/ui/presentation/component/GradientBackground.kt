package com.curiousapps.emojiapiupdate.ui.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GradientBackground() {
    val gradient = Brush.verticalGradient(
        listOf(
            Color.LightGray,
            Color.Cyan,
            Color.Cyan,
            Color.Cyan,
            Color.Cyan,
            Color.Black
        )
    )
    Box(
        modifier = Modifier.fillMaxSize().background(gradient)
    )
}