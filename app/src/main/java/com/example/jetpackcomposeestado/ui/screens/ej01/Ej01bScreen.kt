package com.example.jetpackcomposeestado.ui.screens.ej01

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
private fun StatefulCounter(modifier: Modifier = Modifier) {   // (1)
    var count by rememberSaveable { mutableStateOf(0) }
    // (2)
    StatelessCounter(
        value = count,
        onValueChange = { count = it },
        modifier = modifier
    )
}

/**
 * Función sin estado (más reutilizable y fácil de testear)
 */
@Composable
private fun StatelessCounter(
    value: Int,
    onValueChange: (Int) -> Unit,  // (2)
    modifier: Modifier = Modifier, // (1)
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (value > 0) {
            Text("Cuenta: $value")
        }
        Button(
            onClick = { onValueChange(value+1) },
            enabled = value < 10, // Se desabilita el botón si la cuenta llega a 10
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Contar")
        }
    }
}


/**
 *
 * (1) Es una buena práctica el pasar un Modifier por defecto a todas las funciones composables.
 * Esto incrementa su reusabilidad. Debe aparecer como el primer parámetro opcional de la lista,
 * después de todos los parámetros obligatorios.
 *
 *
 * (2) State hoisting (elevación de estado) es un patrón por el que el estado se mueve a otra
 * función que llama a la que define la interfaz de usuario.
 * Normalmente se reemplaza el estado por dos parámetros:
 *      - value:(T)
 *          El valor a mostrar
 *      - onValueChange: (T) -> Unit
 *          Función que modifica ese valor, donde T es el nuevo valor propuesto
 *
 */