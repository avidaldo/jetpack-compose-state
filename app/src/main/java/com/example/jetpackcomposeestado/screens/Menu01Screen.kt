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
fun Ej01Screen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ejemplo01a.route) }) {
            Text(text = "Botón simple")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo01b.route) }) {
            Text(text = "Contador con State Hoisting")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo01c.route) }) {
            Text(text = "Cambiador con State Hoisting")
        }
    }

}