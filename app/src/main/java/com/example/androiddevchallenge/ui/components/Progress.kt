package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Progress(value: Float = 0.33f) {
    val animatedProgress by animateFloatAsState(
        targetValue = value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    CircularProgressIndicator(
        progress = animatedProgress,
        strokeWidth = 10.dp,
        modifier = Modifier.fillMaxWidth()
            .aspectRatio(1f)
    )
}