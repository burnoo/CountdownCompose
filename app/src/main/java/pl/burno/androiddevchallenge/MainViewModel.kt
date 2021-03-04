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
package pl.burno.androiddevchallenge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.burno.androiddevchallenge.model.Time
import pl.burno.androiddevchallenge.model.toUiTime
import pl.burno.androiddevchallenge.ui.model.UiTime
import pl.burno.androiddevchallenge.ui.model.UiTimePosition
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.MINUTE_TENS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.MINUTE_UNITS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.SECONDS_TENS
import pl.burno.androiddevchallenge.ui.model.UiTimePosition.SECONDS_UNITS

class MainViewModel : ViewModel() {
    private var currentTime = Time(minutes = 0, seconds = 0)
        set(value) {
            field = value
            _currentUiTime.value = value.toUiTime()
        }
    private var startTime: Time = currentTime

    private val _currentUiTime = MutableStateFlow(currentTime.toUiTime())
    val currentUiTime: StateFlow<UiTime> = _currentUiTime

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress

    private var tickerJob: Job? = null

    fun onUp(position: UiTimePosition) {
        currentTime = when (position) {
            SECONDS_UNITS -> currentTime.addSecondsUnit()
            SECONDS_TENS -> currentTime.addSecondsTen()
            MINUTE_UNITS -> currentTime.addMinutesUnit()
            MINUTE_TENS -> currentTime.addMinutesTen()
        }
        updateProgressAfterChange()
    }

    fun onDown(position: UiTimePosition) {
        currentTime = when (position) {
            SECONDS_UNITS -> currentTime.minusSecondsUnit()
            SECONDS_TENS -> currentTime.minusSecondsTen()
            MINUTE_UNITS -> currentTime.minusMinutesUnit()
            MINUTE_TENS -> currentTime.minusMinutesTen()
        }
        updateProgressAfterChange()
    }

    fun onReset() {
        if (_isRunning.value) stopTimer()
        currentTime = Time(minutes = 0, seconds = 0)
        updateProgressAfterChange()
    }

    private fun updateProgressAfterChange() {
        _progress.value = if (currentTime.isZero) 0f else 1f
    }

    fun onStartStop() {
        if (currentTime.isZero) return
        if (isRunning.value) {
            stopTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        _isRunning.value = true
        if (progress.value == 1f) startTime = currentTime
        tickerJob = viewModelScope.launch {
            while (true) {
                delay(1000L)
                currentTime = currentTime.tickDown()
                _progress.value = currentTime / startTime
                if (currentTime.isZero) stopTimer()
            }
        }
    }

    private fun stopTimer() {
        tickerJob?.cancel()
        tickerJob = null
        _isRunning.value = false
    }
}
