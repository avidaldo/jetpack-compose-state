package com.example.jetpackcomposeestado.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true)
@Composable
fun Ej02Screen() {
    var linea by remember { mutableStateOf(String()) }
    // TODO: por qué no funciona con StringBuilder?

    Box(Modifier.fillMaxSize().padding(60.dp)) {
        Text(text = linea, Modifier.align(Alignment.TopCenter))
        Button(
            onClick = { linea += "X" },
            Modifier.align(Alignment.CenterStart)
        ) {
            Text(text = "X")
        }
        Button(
            onClick = { linea += "O" },
            Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text = "O")
        }
    }
}