package com.example.jetpackcomposeestado.ui.screens.ej00

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


// https://developer.android.com/codelabs/jetpack-compose-state
// https://github.com/googlecodelabs/android-compose-codelabs/tree/main/BasicStateCodelab

@Composable
fun Ej00PruebasScreen() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            10.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        RowCase(text = "Caso 0") { Caso00() }
        RowCase(text = "Caso 1") { Caso01() }
        RowCase(text = "Caso 2") { Caso02() }
        RowCase(text = "Caso 2b") { Caso02b() }
        RowCase(text = "Caso 3") { Caso03() }
        RowCase(text = "Caso 3b") { Caso03b() }
        RowCase(text = "Caso 4") { Caso04() }
        RowCase(text = "Caso 5") { Caso05() }
        RowCase(text = "Caso 6") { Caso06() }
    }
}

@Composable
private fun RowCase(text: String, content: @Composable () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(2.dp)
            .background(Color.Cyan),
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
    ) {
        Text(text = text)
        content()  // TODO: es raro llamar así
    }
}


@Composable
private fun Caso00() {
    val count: MutableState<Int> = mutableStateOf(0)
    Log.i("---", "count = $count")

    Button(
        onClick = {
            count.value++
            Log.i("---", "count = $count")
        },
    ) {}

}


@Composable
private fun Caso01() {
    var count01 = 0

    Button(
        onClick = {
            count01++
            Log.i("---", "Caso1: count = $count01")
        },
    ) {
        Text("$count01")
    }

}

/** Caso 1:
 * Cuando se hace click en el botón no sucede nada. Compose no detecta el cambio en cuenta como un
 * cambio de estado ya que no se le ha indicado que deba recomponer la función cuando cambie este estado.
 *
 * Cuando hay un cambio de estado, Compose reejecuta las funciones composables que an sido afectadas
 * (recomposición).
 */


@Composable
private fun Caso02() {
    val count02: MutableState<Int> = mutableStateOf(0)
    Log.i("---", "Caso2: count-out = $count02")

    Button(
        onClick = {
            count02.value++
            Log.i("---", "Caso2: count-in = $count02")
        },
    ) {
        Text(text = "${count02.value}")
    }
}

/** Caso 2:
 * Usando MutableState creamos un estado observable por Compose. El botón se recompone cuando
 * este cambia ya que es dentro de él donde se realizan las lecturas de la variable.
 *
 * TODO: Sin embargo no recompone toda la función y por eso no se reinicia el contador. ¿No debería?
 */


@Composable
private fun Caso02b() {
    val count03: MutableState<Int> = mutableStateOf(0)

    Row(
        // Sutituyo Button por Row y la hago clicacke y parecida a un botón
        Modifier
            .clickable {
                count03.value++
            }
            .background(Color.Blue)
            .padding(20.dp),
    ) {
        Text(text = "${count03.value}")
    }

}


@Composable
private fun Caso03() {
    val count03: MutableState<Int> = mutableStateOf(0) // Al recomponerse se reinicializa
    Log.i("---", "count - out = $count03") // Pasa por aquí

    Row() {
        Button(
            onClick = {
                count03.value++
                Log.i("---", "count - in = $count03") // Tras incremento, recompone Caso03() y 1 aquí
                // , pero la siguiente vez se ha reinicializado a 0 al
            },
        ) {
            Text(text = "${count03.value}")
        }
        Text(text = "${count03.value}")  // Esta lectura obliga a recomponer
    }

}


@Composable
private fun Caso03b() {
    val count03: MutableState<Int> = mutableStateOf(0)
    Log.i("---", "count - out = $count03")

    Button( // Sustituyo la Row por un Button
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
    ) {// El content de button se pasa a una Row anidada interna
        Button(
            onClick = {
                count03.value++
                Log.i("---", "count - in = $count03") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
            },
        ) {
            Text(text = "${count03.value}")
        }
        Text(text = "${count03.value}")  // Esta lectura obliga a recomponer

    }
}

/**
 * Al leerse el valor en otra función composable, vuelve a ejecutarse la línea que la inicializa a 0, por lo que
 * seguimos sin observar cambios en la UI. Necesitamos una forma de guardar el estado a través de las
 * recomposiciones.
 */


@Composable
private fun Caso04() {
    val count04: MutableState<Int> = remember { mutableStateOf(0) }

    Row() {
        Button(
            onClick = {
                count04.value++
                Log.i("---", "count = $count04.value")
            },
        ) {
            Text(text = "${count04.value}")
        }
        Text(text = "${count04.value}")

    }
}

/**
 * La función remembers almacena el valor calculado a través de las recomposiciones.
 */


@Composable
private fun Caso05() {
    var count05 by remember { mutableStateOf(0) }

    Row() {
        Button(
            onClick = {
                count05++
                Log.i("---", "count = $count05")
            },
        ) {
            Text(text = "$count05")
        }
        Text(text = "$count05")

    }
}

/**
 * Podemos usar la delegación de propiedades de Kotlin
 * (https://kotlinlang.org/docs/delegated-properties.html)
 * para simplificar el uso de remember. Esto nos permitirá no llamar a los getters del valor que el
 * mutableStateOf envuelve, sino delegar la gestión de count en él utilizando el patrón delegation.
 * De este modo tendremos un código más legible.
 *
 * Aún así, si la activity se elimina por un cambio en su ciclo de vida (por ejemplo si cambiamos
 * la orientación de la pantalla), el estado se pierde.
 */


@Composable
private fun Caso06() {
    var count06 by rememberSaveable { mutableStateOf(0) }

    Row() {
        Button(
            onClick = {
                count06++
                Log.i("---", "count = $count06")
            },
        ) {
            Text(text = "$count06")
        }
        Text(text = "$count06")

    }
}

/**
 * Con rememberSaveable podemos guardar el estado a través de cambios en el ciclo de vida de
 * la activity.
 */