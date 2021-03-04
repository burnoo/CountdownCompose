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
