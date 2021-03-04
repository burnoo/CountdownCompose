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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.burno.androiddevchallenge.ui.model.UiTime
import pl.burno.androiddevchallenge.ui.model.UiTimePosition
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.MINUTE_TENS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.MINUTE_UNITS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.SECONDS_TENS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.SECONDS_UNITS

@Preview
@Composable
fun Timer(
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
