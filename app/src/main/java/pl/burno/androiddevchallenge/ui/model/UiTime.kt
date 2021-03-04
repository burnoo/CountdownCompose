package pl.burno.androiddevchallenge.ui.model

import androidx.annotation.IntRange

data class UiTime(
    @IntRange(from = 0, to = 9) val minuteTens: Int = 0,
    @IntRange(from = 0, to = 9) val minuteUnits: Int = 0,
    @IntRange(from = 0, to = 9) val secondTens: Int = 0,
    @IntRange(from = 0, to = 9) val secondUnits: Int = 0,
) {
    init {
        require(minuteTens in 0..9)
        require(minuteUnits in 0..9)
        require(secondTens in 0..5)
        require(secondUnits in 0..9)
    }
}