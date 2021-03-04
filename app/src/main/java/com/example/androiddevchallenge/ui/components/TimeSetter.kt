package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition
import com.example.androiddevchallenge.ui.model.UiTimePosition.*

@Composable
fun TimeSetter() {
    val viewModel = viewModel<MainViewModel>()
    val timeSetterState = viewModel.currentSetterTime.collectAsState()

    TimeSetterStateless(timeSetterState.value, viewModel::onUp, viewModel::onDown)
}

@Preview
@Composable
fun TimeSetterStateless(
    time: UiTime = UiTime(),
    onUp: (UiTimePosition) -> Unit = {},
    onDown: (UiTimePosition) -> Unit = {}
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        NumberSetter(
            count = time.minuteTens,
            onUp = { onUp(MINUTE_TENS) },
            onDown = { onDown(MINUTE_TENS) }
        )
        NumberSetter(
            count = time.minuteUnits,
            onUp = { onUp(MINUTE_UNITS) },
            onDown = { onDown(MINUTE_UNITS) }
        )
        Text(text = ":", style = MaterialTheme.typography.h3)
        NumberSetter(
            count = time.secondTens,
            onUp = { onUp(SECONDS_TENS) },
            onDown = { onDown(SECONDS_TENS) }
        )
        NumberSetter(
            count = time.secondUnits,
            onUp = { onUp(SECONDS_UNITS) },
            onDown = { onDown(SECONDS_UNITS) }
        )
    }
}