/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.burno.androiddevchallenge.ui.components

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
import pl.burno.androiddevchallenge.MainViewModel
import pl.burno.androiddevchallenge.ui.model.UiTime
import pl.burno.androiddevchallenge.ui.model.UiTimePosition

@Composable
fun MainScreen() {
    val viewModel = viewModel<MainViewModel>()
    val timeSetterState = viewModel.currentUiTime.collectAsState()
    val isRunning = viewModel.isRunning.collectAsState()
    val progress = viewModel.progress.collectAsState()

    MainLayout(
        time = timeSetterState.value,
        isRunning = isRunning.value,
        progress = progress.value,
        onUp = viewModel::onUp,
        onDown = viewModel::onDown,
        onStartStop = viewModel::onStartStop,
        onReset = viewModel::onReset
    )
}

@Preview
@Composable
fun MainLayout(
    time: UiTime = UiTime(),
    isRunning: Boolean = false,
    progress: Float = 0.33f,
    onUp: (UiTimePosition) -> Unit = {},
    onDown: (UiTimePosition) -> Unit = {},
    onStartStop: () -> Unit = {},
    onReset: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Timer(time = time, isEnabled = !isRunning, onUp = onUp, onDown = onDown)
        Buttons(
            modifier = Modifier.padding(top = 212.dp),
            isRunning = isRunning,
            onStartStopClick = onStartStop,
            onResetClick = onReset
        )
        Progress(value = progress)
    }
}
