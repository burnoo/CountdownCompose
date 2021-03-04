package com.example.androiddevchallenge.model

import androidx.annotation.IntRange
import com.example.androiddevchallenge.ui.model.UiTime

data class Time(
    @IntRange(from = 0, to = 99) val minutes: Int,
    @IntRange(from = 0, to = 59) val seconds: Int,
) {
    init {
        require(minutes in 0..99)
        require(seconds in 0..59)
    }

    val isZero = minutes == 0 && seconds == 0

    fun tickDown(): Time = when {
        seconds > 0 -> copy(seconds = seconds - 1)
        minutes > 0 -> copy(minutes = minutes - 1, seconds = 59)
        else -> throw IllegalStateException("tick down on 00:00")
    }

    fun addSecondsUnit(): Time = copy(seconds = seconds.plusUnit())
    fun addSecondsTen(): Time = copy(seconds = seconds.plusTen(maxExclusive = 6))
    fun addMinutesUnit(): Time = copy(minutes = minutes.plusUnit())
    fun addMinutesTen(): Time = copy(minutes = minutes.plusTen())

    fun minusSecondsUnit(): Time = copy(seconds = seconds.minusUnit())
    fun minusSecondsTen(): Time = copy(seconds = seconds.minusTen(maxExclusive = 6))
    fun minusMinutesUnit(): Time = copy(minutes = minutes.minusUnit())
    fun minusMinutesTen(): Time = copy(minutes = minutes.minusTen())

    private fun Int.plusUnit() = (this / 10 * 10) + (this + 1) % 10
    private fun Int.plusTen(maxExclusive: Int = 10) =
        (this / 10 + 1) % maxExclusive * 10 + this % 10

    private fun Int.minusUnit() = (this / 10 * 10) + (this + 10 - 1) % 10
    private fun Int.minusTen(maxExclusive: Int = 10) =
        (this / 10 + maxExclusive - 1) % maxExclusive * 10 + this % 10

    operator fun div(time: Time): Float {
        if (time.isZero) return 1f
        if (isZero) return 0f
        return (minutes * 60 + seconds).toFloat() / (time.minutes * 60 + time.seconds)
    }
}

fun Time.toUiTime(): UiTime = UiTime(
    minuteTens = minutes / 10,
    minuteUnits = minutes % 10,
    secondTens = seconds / 10,
    secondUnits = seconds % 10
)