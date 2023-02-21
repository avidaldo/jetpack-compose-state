package com.example.jetpackcomposeestado.ui.screens.ej03

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/* https://devexperto.com/estado-jetpack-compose/ */

@Preview(showBackground = true)
@Composable
fun Ej03aScreen() {
    //var text by remember { mutableStateOf("") }  // Guarda el estado ante recomposición pero no ante cambios de configuración
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
        )
        Button(
            onClick = { text = "" }, // Vaciamos el texto al pulsar
            enabled = text.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Clear")
        }
    }
}