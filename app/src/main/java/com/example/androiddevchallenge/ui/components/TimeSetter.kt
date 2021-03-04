package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition
import com.example.androiddevchallenge.ui.model.UiTimePosition.*

@Preview
@Composable
fun TimeSetter(
    time: UiTime = UiTime(),
    isEnabled: Boolean = true,
    onUp: (UiTimePosition) -> Unit = {},
    onDown: (UiTimePosition) -> Unit = {},
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        NumberSetter(
            count = time.minuteTens,
            isEnabled = isEnabled,
            onUp = { onUp(MINUTE_TENS) },
            onDown = { onDown(MINUTE_TENS) }
        )
        NumberSetter(
            count = time.minuteUnits,
            isEnabled = isEnabled,
            onUp = { onUp(MINUTE_UNITS) },
            onDown = { onDown(MINUTE_UNITS) }
        )
        Text(text = ":", style = MaterialTheme.typography.h3, modifier = Modifier.padding(6.dp))
        NumberSetter(
            count = time.secondTens,
            isEnabled = isEnabled,
            onUp = { onUp(SECONDS_TENS) },
            onDown = { onDown(SECONDS_TENS) }
        )
        NumberSetter(
            count = time.secondUnits,
            isEnabled = isEnabled,
            onUp = { onUp(SECONDS_UNITS) },
            onDown = { onDown(SECONDS_UNITS) }
        )
    }
}