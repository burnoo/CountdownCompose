package com.example.androiddevchallenge

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Time
import com.example.androiddevchallenge.model.toUiTime
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition
import com.example.androiddevchallenge.ui.model.UiTimePosition.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private var currentTime = Time(minutes = 0, seconds = 0)
        set(value) {
            field = value
            _currentUiTime.value = value.toUiTime()
        }
    private val _currentUiTime = MutableStateFlow(currentTime.toUiTime())
    val currentUiTime: StateFlow<UiTime> = _currentUiTime

    private val _isRunning = MutableStateFlow(true)
    val isRunning: StateFlow<Boolean> = _isRunning

    fun onUp(position: UiTimePosition) {
        currentTime = when (position) {
            SECONDS_UNITS -> currentTime.addSecondsUnit()
            SECONDS_TENS -> currentTime.addSecondsTen()
            MINUTE_UNITS -> currentTime.addMinutesUnit()
            MINUTE_TENS -> currentTime.addMinutesTen()
        }
    }

    fun onDown(position: UiTimePosition) {
        currentTime = when (position) {
            SECONDS_UNITS -> currentTime.minusSecondsUnit()
            SECONDS_TENS -> currentTime.minusSecondsTen()
            MINUTE_UNITS -> currentTime.minusMinutesUnit()
            MINUTE_TENS -> currentTime.minusMinutesTen()
        }
    }

    fun onStartStop() {
        _isRunning.value = !_isRunning.value
    }
}