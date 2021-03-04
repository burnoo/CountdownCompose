package com.example.androiddevchallenge.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun StartStopButton(
    modifier: Modifier = Modifier,
    isRunning: Boolean = false,
    onClick: () -> Unit = {}
) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = if (isRunning) "Stop" else "Start")
    }
}