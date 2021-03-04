package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition

@Composable
fun MainScreen() {
    val viewModel = viewModel<MainViewModel>()
    val timeSetterState = viewModel.currentSetterTime.collectAsState()

    val isRunning = viewModel.isRunning.collectAsState()

    MainLayout(timeSetterState.value, isEnabled = isRunning.value, viewModel::onUp, viewModel::onDown)
}

@Preview
@Composable
fun MainLayout(
    time: UiTime = UiTime(),
    isEnabled: Boolean = true,
    onUp: (UiTimePosition) -> Unit = {},
    onDown: (UiTimePosition) -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TimeSetter(time, isEnabled, onUp, onDown)
    }
}