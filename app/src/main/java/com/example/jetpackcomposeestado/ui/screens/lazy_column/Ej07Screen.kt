package com.example.jetpackcomposeestado.ui.screens.lazy_column

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
/* getValue y setValue no siempre se añaden bien automátiamente y son necesarios para evitar el error
"Type 'TypeVariable(T)' has no method 'getValue(Nothing?, KProperty<*>)' and thus it cannot serve as a delegate" */
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

val list7 = List(10) { Random.nextBoolean()}
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-boolean.html

@Composable
fun Ej07Screen() {
    var lastState by rememberSaveable { mutableStateOf(false) }
    val changeLastState : (Boolean) -> Unit = {lastState = it}

    MyLazyColumn(lastState = lastState, changeLastState = changeLastState)

}

@Composable
private fun MyLazyColumn(lastState: Boolean, changeLastState: (Boolean) -> Unit) {

    //var lastState by rememberSaveable { mutableStateOf(false) }  // (1)

    LazyColumn {

        items(list7) {

            val string = "$lastState // $it"
            Log.d("DEBUG", string)
            Text(text = string, Modifier.padding(50.dp))

            //lastState = it  // (1)
            changeLastState(it) //  (1)
        }
    }
}

/**
 * (1) Sin State Hoisting, esa línea hace una modificación de estado que genera una recomposición
 * de toda la función composable. En este caso, se queda en bucle recomponiéndose sin parar, como
 * se puede observar con el log.
 *
 * De todos modos, este caso siguen sin funcionar correctamente como se puede observar. Cada vez
 * que se cambia el estado lastState, la función Ej07Screen() se recompone, volviendo a iniciarlizarse
 */



