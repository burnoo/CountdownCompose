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
fun CurrentTime(time: UiTime = UiTime(0, 0)) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(time.firstDigit.toString(), style = MaterialTheme.typography.h3)
        Text(time.secondDigit.toString(), style = MaterialTheme.typography.h3)
        Text(text = ":", style = MaterialTheme.typography.h3)
        Text(time.thirdDigit.toString(), style = MaterialTheme.typography.h3)
        Text(time.fourthDigit.toString(), style = MaterialTheme.typography.h3)
    }
}