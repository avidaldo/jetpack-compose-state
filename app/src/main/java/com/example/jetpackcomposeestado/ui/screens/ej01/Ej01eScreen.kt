package com.example.jetpackcomposeestado.ui.screens.ej01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Ej01eScreen() = StatefulCounter()


@Composable
private fun StatefulCounter() {
    var waterCount by remember { mutableStateOf(0) }
    var juiceCount by remember { mutableStateOf(0) }

    Column() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            StatelessCounter(waterCount, { waterCount++ })
            StatelessReset({ waterCount=0 })
        }
        StatelessCounter(juiceCount, { juiceCount++ })
    }
}


@Composable
private fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
private fun StatelessReset(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(onClick = onClick) {
        Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
    }
}

/**
 * Aquí se ejemplifica las ventajas del state hoisting para poder reutilizar las funciones sin
 * estado.
 */