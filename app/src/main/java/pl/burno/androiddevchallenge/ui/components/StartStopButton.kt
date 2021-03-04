package pl.burno.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Buttons(
    modifier: Modifier = Modifier,
    isRunning: Boolean = false,
    onStartStopClick: () -> Unit = {},
    onResetClick: () -> Unit = {},
) {
    Row(modifier = modifier) {
        StartStopButton(isRunning, onStartStopClick)
        ResetButton(onResetClick)
    }
}

@Composable
fun StartStopButton(
    isRunning: Boolean = false,
    onClick: () -> Unit = {}
) {
    Button(modifier = Modifier.padding(end = 4.dp), onClick = onClick) {
        Text(text = if (isRunning) "Stop" else "Start")
    }
}

@Composable
fun ResetButton(onClick: () -> Unit = {}) {
    Button(modifier = Modifier.padding(start = 4.dp), onClick = onClick) {
        Text(text = "Reset")
    }
}