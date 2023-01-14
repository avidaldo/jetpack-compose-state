package com.example.jetpackcompose1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetpackcomposeestado.navigation.Screens

@Composable
fun MainScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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
        Button(onClick = { navController.navigate(route = Screens.Ejemplo05.route) }) {
            Text(text = "Ejemplo 5")
        }
    }

}