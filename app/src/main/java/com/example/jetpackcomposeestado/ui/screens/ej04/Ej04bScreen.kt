package com.example.jetpackcomposeestado.ui.screens.ej04

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Ej04bScreen() {  // Usando State Hoisting
    var name by rememberSaveable { mutableStateOf("") }
    Ej04bContent(name = name, onNameChange = { name = it })
}

@Composable
fun Ej04bContent(name: String, onNameChange: (String) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        OutlinedTextField(value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Name") }
        )

        if (name.isNotBlank())
            Text(text = "¡Hola, $name!", Modifier.padding(10.dp))
    }
}