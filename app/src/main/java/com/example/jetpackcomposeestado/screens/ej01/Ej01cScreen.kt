package com.example.jetpackcomposeestado.screens.ej01

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


@Composable
fun Ej01cScreen() = StatefulChanger()

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

