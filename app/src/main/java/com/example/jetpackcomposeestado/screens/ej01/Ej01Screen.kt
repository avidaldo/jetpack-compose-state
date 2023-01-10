package com.example.jetpackcomposeestado.screens.ej01

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun Ej01Screen() {

    var cuenta by remember { mutableStateOf(0) }

    Box(Modifier.fillMaxSize()) {
        Button(
            onClick = { cuenta += 1 },
            Modifier.align(Alignment.Center)
        ) {
            Text(text = "$cuenta")
        }
    }
}