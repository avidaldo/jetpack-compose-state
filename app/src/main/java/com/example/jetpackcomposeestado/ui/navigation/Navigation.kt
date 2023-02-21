package com.example.jetpackcomposeestado.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose1.screens.MainScreen
import com.example.jetpackcomposeestado.screens.Ej01Screen
import com.example.jetpackcomposeestado.screens.Ej03Screen
import com.example.jetpackcomposeestado.screens.Ej04Screen
import com.example.jetpackcomposeestado.ui.screens.ej00.Ej00Screen
import com.example.jetpackcomposeestado.ui.screens.ej01.*
import com.example.jetpackcomposeestado.ui.screens.ej02.Ej02Screen
import com.example.jetpackcomposeestado.ui.screens.ej03.Ej03aScreen
import com.example.jetpackcomposeestado.ui.screens.ej03.Ej03bScreen
import com.example.jetpackcomposeestado.ui.screens.ej04.Ej04aScreen
import com.example.jetpackcomposeestado.ui.screens.ej04.Ej04bScreen
import com.example.jetpackcomposeestado.ui.screens.ej04.Ej04cScreen
import com.example.jetpackcomposeestado.ui.screens.lazy_column.Ej06Screen
import com.example.jetpackcomposeestado.ui.screens.lazy_column.Ej07Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {

        composable(route = Screens.MainScreen.route) { MainScreen(navController) }
        composable(route = Screens.Ejemplo00.route) { Ej00Screen() }

        composable(route = Screens.Ejemplo01.route) { Ej01Screen(navController) }
        composable(route = Screens.Ejemplo01a.route) { Ej01aScreen() }
        composable(route = Screens.Ejemplo01b.route) { Ej01bScreen() }
        composable(route = Screens.Ejemplo01c.route) { Ej01cScreen() }
        composable(route = Screens.Ejemplo01d.route) { Ej01dScreen() }
        composable(route = Screens.Ejemplo01e.route) { Ej01eScreen() }

        composable(route = Screens.Ejemplo02.route) { Ej02Screen() }

        composable(route = Screens.Ejemplo03.route) { Ej03Screen(navController) }
        composable(route = Screens.Ejemplo03a.route) { Ej03aScreen() }
        composable(route = Screens.Ejemplo03b.route) { Ej03bScreen() }

        composable(route = Screens.Ejemplo04.route) { Ej04Screen(navController) }
        composable(route = Screens.Ejemplo04a.route) { Ej04aScreen() }
        composable(route = Screens.Ejemplo04b.route) { Ej04bScreen() }
        composable(route = Screens.Ejemplo04c.route) { Ej04cScreen() }

        composable(route = Screens.Ejemplo06.route) { Ej06Screen() }
        composable(route = Screens.Ejemplo07.route) { Ej07Screen() }



    }
}



