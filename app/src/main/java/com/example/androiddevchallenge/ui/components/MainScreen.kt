package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition

@Composable
fun MainScreen() {
    val viewModel = viewModel<MainViewModel>()
    val timeSetterState = viewModel.currentSetterTime.collectAsState()

    val isRunning = viewModel.isRunning.collectAsState()

    MainLayout(
        timeSetterState.value,
        isRunning = isRunning.value,
        viewModel::onUp,
        viewModel::onDown,
        viewModel::onStartStop
    )
}

@Preview
@Composable
fun MainLayout(
    time: UiTime = UiTime(),
    isRunning: Boolean = false,
    onUp: (UiTimePosition) -> Unit = {},
    onDown: (UiTimePosition) -> Unit = {},
    onStartStop: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TimeSetter(time = time, isEnabled = !isRunning, onUp = onUp, onDown = onDown)
        StartStopButton(
            modifier = Modifier.padding(top = 232.dp),
            isRunning = isRunning,
            onClick = onStartStop
        )
    }
}