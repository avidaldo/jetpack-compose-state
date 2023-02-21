package com.example.jetpackcomposeestado.ui.screens.lazy_column

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random


val list6 = List(10) { Random.nextInt() }

@Composable
fun Ej06Screen() {
    val list6 = remember { mutableStateListOf<Int>() }.apply {
        addAll(List(10) { Random.nextInt() })
    }

    LazyColumn {
        items(list6) {
            Text(text = it.toString(),
                Modifier
                    .padding(50.dp)
                    .background(Color.Cyan))
            Log.d("DEBUG", it.toString())
        }
    }


}



