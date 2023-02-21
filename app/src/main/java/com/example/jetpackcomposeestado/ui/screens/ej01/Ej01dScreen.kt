package com.example.jetpackcomposeestado.ui.screens.ej01

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable


@Composable
fun Ej01dScreen() = StatefulChanger()

@Composable
fun StatefulChanger() {
    var showTime by rememberSaveable { mutableStateOf(false) }
    MyButton(showTime.toString()) { showTime = !showTime }
}

private @Composable
fun MyButton(value: String, onClick: () -> Unit ) {
    Button(onClick = onClick) {
        Text(text = value)
    }
}

