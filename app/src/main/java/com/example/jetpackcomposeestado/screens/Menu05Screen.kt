package com.example.jetpackcomposeestado.screens

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
fun Ej05Screen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ejemplo05a.route) }) {
            Text(text = "Versión básica")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo05b.route) }) {
            Text(text = "Con State Hoisting")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo05c.route) }) {
            Text(text = "Variante mejorada")
        }
    }

}