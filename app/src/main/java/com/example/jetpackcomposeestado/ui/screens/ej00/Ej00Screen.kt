package com.example.jetpackcomposeestado.ui.screens.ej00

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeestado.ui.navigation.Screens


// https://developer.android.com/codelabs/jetpack-compose-state
// https://github.com/googlecodelabs/android-compose-codelabs/tree/main/BasicStateCodelab

@Preview(showBackground = true)
@Composable
fun Ej00Screen() {

    Column(Modifier.fillMaxSize()) {
        Caso01()
        Caso02()
        Caso03()
        Caso04()
        Caso05()
        Caso06()
    }


}

@Composable
private fun Caso01() {
    var count = 0
    Log.i("---", "count = $count")

    Button(
        onClick = { count++ },
    ) {
        Text(text = "$count")
    }

}

/**
 * Cuando se hace click en el botón no sucede nada. Compose no detecta el cambio en cuenta como un
 * cambio de estado ya que no se le ha indicado que deba recomponer la función cuando cambie este estado
 *
 *
 * Cuando hay un cambio de estado, Compose reejecuta las funciones composables que an sido afectadas
 * (recomposición).
 *
 */

@Composable
fun Caso02() {
    val count: MutableState<Int> = mutableStateOf(0)
    Log.i("---", "count = $count")

    Button(
        onClick = { count.value++ },
    ) {
        Text(text = "${count.value}")
    }
}
/**
 * Usando MutableState creamos un estado observable por Compose. El botón se recompone cuando
 * este cambia. (TODO: no tengo del todo claro por qué este caso funciona y no como el siguiente)
 */

@Composable
fun Caso03() {
    val count: MutableState<Int> = mutableStateOf(0)
    Log.i("---", "count = $count.value")

    Row() {
        Button(
            onClick = { count.value++ },
        ) {
            Text(text = "${count.value}")
        }
        Text(text = "${count.value}")  // Esta lectura obliga a recomponer

    }
}

/**
 * Al leerse el valor en otra función composable, vuelve a ejecutarse la línea que la inicializa a 0, por lo que
 * seguimos sin observar cambios en la UI. Necesitamos una forma de guardar el estado a través de las
 * recomposiciones.
 */


@Composable
fun Caso04() {
    val count: MutableState<Int> = remember { mutableStateOf(0) }
    Log.i("---", "count = $count.value")

    Row() {
        Button(
            onClick = { count.value++ },
        ) {
            Text(text = "${count.value}")
        }
        Text(text = "${count.value}")

    }
}

/**
 * La función remembers almacena el valor calculado a través de las recomposiciones.
 */



@Composable
fun Caso05() {
    var count by remember { mutableStateOf(0) }
    Log.i("---", "count = $count")

    Row() {
        Button(
            onClick = { count++ },
        ) {
            Text(text = "$count")
        }
        Text(text = "$count")

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
fun Caso06() {
    var count by rememberSaveable { mutableStateOf(0) }
    Log.i("---", "count = $count")

    Row() {
        Button(
            onClick = { count++ },
        ) {
            Text(text = "$count")
        }
        Text(text = "$count")

    }
}

/**
 * Con rememberSaveable podemos guardar el estado a través de cambios en el ciclo de vida de
 * la activity.
 */