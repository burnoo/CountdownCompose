package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.model.UiTime

@Preview
@Composable
fun TimeSetter(time: UiTime = UiTime(0, 0)) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        NumberSetter(count = time.firstDigit)
        NumberSetter(count = time.secondDigit)
        Text(text = ":", style = MaterialTheme.typography.h3)
        NumberSetter(count = time.thirdDigit)
        NumberSetter(count = time.fourthDigit)
    }
}