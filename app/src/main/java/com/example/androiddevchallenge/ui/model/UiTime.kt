package com.example.androiddevchallenge.ui.model

import androidx.annotation.IntRange

data class UiTime(
    @IntRange(from = 0, to = 99) val hours: Int,
    @IntRange(from = 0, to = 59) val minutes: Int
) {
    init {
        require(hours in 0..99)
        require(minutes in 0..59)
    }
    val firstDigit: Int = hours / 10
    val secondDigit: Int = hours % 10
    val thirdDigit: Int = minutes / 10
    val fourthDigit: Int = minutes % 10
}