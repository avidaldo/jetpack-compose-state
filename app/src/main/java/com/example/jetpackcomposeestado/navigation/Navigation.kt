package com.example.jetpackcomposeestado.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose1.screens.MainScreen
import com.example.jetpackcomposeestado.screens.Ej03Screen
import com.example.jetpackcomposeestado.screens.Ej04Screen
import com.example.jetpackcomposeestado.screens.ej01.Ej01Screen
import com.example.jetpackcomposeestado.screens.ej02.Ej02Screen
import com.example.jetpackcomposeestado.screens.ej03.Ej03aScreen
import com.example.jetpackcomposeestado.screens.ej03.Ej03bScreen
import com.example.jetpackcomposeestado.screens.ej04.Ej04aScreen
import com.example.jetpackcomposeestado.screens.ej04.Ej04bScreen
import com.example.jetpackcomposeestado.screens.ej04.Ej04cScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {

        composable(route = Screens.MainScreen.route) { MainScreen(navController) }

        composable(route = Screens.Ejemplo01.route) { Ej01Screen() }

        composable(route = Screens.Ejemplo02.route) { Ej02Screen() }

        composable(route = Screens.Ejemplo03.route) { Ej03Screen(navController) }
        composable(route = Screens.Ejemplo03a.route) { Ej03aScreen() }
        composable(route = Screens.Ejemplo03b.route) { Ej03bScreen() }

        composable(route = Screens.Ejemplo04.route) { Ej04Screen(navController) }
        composable(route = Screens.Ejemplo04a.route) { Ej04aScreen() }
        composable(route = Screens.Ejemplo04b.route) { Ej04bScreen() }
        composable(route = Screens.Ejemplo04c.route) { Ej04cScreen() }

/*        composable(route = Screens.Ejemplo05.route) { Ej05Screen(navController) }
        composable(route = Screens.Ejemplo05a.route) { Ej05aScreen() }
        composable(route = Screens.Ejemplo05b.route) { Ej05bScreen() }*/


/*        composable(route = Screens.Ejemplo06.route) { Ej06Screen() }
        composable(route = Screens.Ejemplo07.route) { Ej07Screen() }
        composable(route = Screens.Ejemplo08.route) { Ej08Screen() }*/

    }
}



