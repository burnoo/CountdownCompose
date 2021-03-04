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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NumberCounterPreview() {
    val count = remember { mutableStateOf(0) }
    NumberSetter(
        count.value,
        onUp = { count.value = (count.value + 1) % 10 }
    ) { count.value = (count.value + 9) % 10 }
}

@Composable
fun NumberSetter(
    count: Int = 0,
    isEnabled: Boolean = true,
    onUp: () -> Unit = {},
    onDown: () -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        NumberSetterIcon(Icons.Default.ArrowDropUp, callback = onUp, isEnabled)
        Text(count.toString(), style = MaterialTheme.typography.h3)
        NumberSetterIcon(Icons.Default.ArrowDropDown, callback = onDown, isEnabled)
    }
}

@Composable
fun NumberSetterIcon(icon: ImageVector, callback: () -> Unit = {}, isEnabled: Boolean) {
    AnimatedVisibility(visible = isEnabled) {
        IconButton(onClick = callback, enabled = isEnabled) {
            Icon(icon, contentDescription = "Icon Up")
        }
    }
}
