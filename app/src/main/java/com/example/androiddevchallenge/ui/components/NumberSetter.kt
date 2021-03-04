package com.example.androiddevchallenge.ui.components

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
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NumberCounterPreview() {
    val count = remember { mutableStateOf(0) }
    NumberSetter(
        count.value,
        onUp = { count.value = (count.value + 1) % 10 },
        onDown = { count.value = (count.value + 9) % 10 }
    )
}

@Composable
fun NumberSetter(
    count: Int = 0,
    onDown: () -> Unit = {},
    onUp: () -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onUp) {
            Icon(Icons.Default.ArrowDropUp, contentDescription = "Icon Up")
        }
        Text(count.toString(), style = MaterialTheme.typography.h3)
        IconButton(onClick = onDown) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Icon Up")
        }
    }
}