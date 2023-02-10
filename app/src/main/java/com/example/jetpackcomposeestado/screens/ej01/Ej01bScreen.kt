package com.example.jetpackcomposeestado.screens.ej01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// https://developer.android.com/codelabs/jetpack-compose-state
// https://github.com/googlecodelabs/android-compose-codelabs/tree/main/BasicStateCodelab

@Composable
fun Ej01bScreen() = StatefulCounter()


/**
 * Función que tiene estado
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    /* State hoisting (elevación de estado) es un patrón por el que el estado se mueve a otra
    función que llama a la que define la interfaz de usuario. */
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

/**
 * Función sin estado (más reutilizable y fácil de testear)
 */
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}
