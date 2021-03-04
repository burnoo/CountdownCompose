package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NumberCounterPreview() {
    val count = remember { mutableStateOf(0) }
    NumberSetter(
        count.value,
        onUp = { count.value = (count.value + 1) % 10 }
    ) { count.value = (count.value + 9) % 10 }
}

@Composable
fun NumberSetter(
    count: Int = 0,
    isEnabled: Boolean = true,
    onUp: () -> Unit = {},
    onDown: () -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        NumberSetterIcon(Icons.Default.ArrowDropUp, callback = onUp, isEnabled)
        Text(count.toString(), style = MaterialTheme.typography.h3)
        NumberSetterIcon(Icons.Default.ArrowDropDown, callback = onDown, isEnabled)
    }
}

@Composable
fun NumberSetterIcon(icon: ImageVector, callback: () -> Unit = {}, isEnabled: Boolean) {
    AnimatedVisibility(visible = isEnabled) {
        IconButton(onClick = callback, enabled = isEnabled) {
            Icon(icon, contentDescription = "Icon Up")
        }
    }
}