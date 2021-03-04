package com.example.androiddevchallenge

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.ui.model.UiTime
import com.example.androiddevchallenge.ui.model.UiTimePosition
import com.example.androiddevchallenge.ui.model.UiTimePosition.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _currentSetterTime = MutableStateFlow(UiTime())
    val currentSetterTime: StateFlow<UiTime> = _currentSetterTime

    fun onUp(position: UiTimePosition) {
        val currentSetterTime = _currentSetterTime.value
        _currentSetterTime.value = when (position) {
            SECONDS_UNITS -> currentSetterTime
                .copy(secondUnits = (currentSetterTime.secondUnits + 1) % 10)
            SECONDS_TENS -> currentSetterTime
                .copy(secondTens = (currentSetterTime.secondTens + 1) % 6)
            MINUTE_UNITS -> currentSetterTime
                .copy(minuteUnits = (currentSetterTime.minuteUnits + 1) % 10)
            MINUTE_TENS -> currentSetterTime
                .copy(minuteTens = (currentSetterTime.minuteTens + 1) % 10)
        }
    }

    fun onDown(position: UiTimePosition) {
        val currentSetterTime = _currentSetterTime.value
        _currentSetterTime.value = when (position) {
            SECONDS_UNITS -> currentSetterTime
                .copy(secondUnits = (currentSetterTime.secondUnits + 9) % 10)
            SECONDS_TENS -> currentSetterTime
                .copy(secondTens = (currentSetterTime.secondTens + 5) % 6)
            MINUTE_UNITS -> currentSetterTime
                .copy(minuteUnits = (currentSetterTime.minuteUnits + 9) % 10)
            MINUTE_TENS -> currentSetterTime
                .copy(minuteTens = (currentSetterTime.minuteTens + 9) % 10)
        }
    }
}