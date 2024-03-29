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
import com.example.jetpackcomposeestado.ui.navigation.Screens

@Composable
fun Ej03Screen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(route = Screens.Ejemplo03a.route) }) {
            Text(text = "Versión básica")
        }
        Button(onClick = { navController.navigate(route = Screens.Ejemplo03b.route) }) {
            Text(text = "Con State Hoisting")
        }
    }

}