package com.example.jetpackcomposeestado.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random
/* getValue y setValue no siempre se añaden bien automátiamente y son necesarios para evitar el error
"Type 'TypeVariable(T)' has no method 'getValue(Nothing?, KProperty<*>)' and thus it cannot serve as a delegate" */

val list = List(10) { Random.nextBoolean()}
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.random/-random/next-boolean.html

@Composable
fun Ej06Screen() {
    var lastState by rememberSaveable { mutableStateOf(false) }

    LazyColumn {

        items(list) {

            val string = "$lastState // $it"
            Log.d("DEBUG", string)  // El log no para. Parece estarse recomponiendo constantemente.
            Text(text = string, Modifier.padding(50.dp))

            lastState = it
        }
    }

}



