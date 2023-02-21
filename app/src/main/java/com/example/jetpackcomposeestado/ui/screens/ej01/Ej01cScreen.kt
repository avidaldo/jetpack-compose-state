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


@Composable
fun Ej01cScreen() = StatefulCounter()


@Composable
private fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ }, // (1)
        modifier = modifier
    )
}


@Composable
private fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,  // (1)
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("Cuenta: $count")
        }
        Button(
            onClick = onIncrement,  // (1)
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Contar")
        }
    }
}

/**
 * (1) En este caso, en lugar de pasar una lamda que recibe el nuevo valor y lo asigna, simplemente
 * pasamos una que directamente incrementa en uno el valor previo.
 * Es importante entender el cambio en las líneas señaladas con respecto al ejemplo anterior. Es,
 * por lo demás, idéntico y tiene el mismo comportamiento.
 *
 *
 * Este patrón, done los eventos van hacia arriba y el estado va hacia abajo se llama
 * Unidirectional Data Flow (UDF) (https://developer.android.com/jetpack/compose/architecture#udf-compose)
 */