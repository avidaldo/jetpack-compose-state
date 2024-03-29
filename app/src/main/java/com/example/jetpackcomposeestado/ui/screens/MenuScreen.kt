package com.example.jetpackcomposeestado.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetpackcomposeestado.ui.navigation.Screens

@Composable
fun MainScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ejemplo00.route) }) {
            Text(text = "Ejemplo 0")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo00Pruebas.route) }) {
            Text(text = "Ejemplo 0 - Pruebas")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo01.route) }) {
            Text(text = "Ejemplo 1")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo02.route) }) {
            Text(text = "Ejemplo 2")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo03.route) }) {
            Text(text = "Ejemplo 3")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo04.route) }) {
            Text(text = "Ejemplo 4")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo06.route) }) {
            Text(text = "Ejemplo 6")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo07.route) }) {
            Text(text = "Ejemplo 7")
        }
    }

}