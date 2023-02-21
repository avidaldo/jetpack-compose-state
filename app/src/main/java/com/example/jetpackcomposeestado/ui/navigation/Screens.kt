package com.example.jetpackcomposeestado.ui.navigation

sealed class Screens(val route: String){
    object MainScreen: Screens("initial_screen")

    object Ejemplo00: Screens("ej00")

    object Ejemplo01: Screens("ej01")
    object Ejemplo01a: Screens("ej01a")
    object Ejemplo01b: Screens("ej01b")
    object Ejemplo01c: Screens("ej01c")
    object Ejemplo01d: Screens("ej01d")
    object Ejemplo01e: Screens("ej01e")

    object Ejemplo02: Screens("ej02")

    object Ejemplo03: Screens("ej03")
    object Ejemplo03a: Screens("ej03a")
    object Ejemplo03b: Screens("ej03b")

    object Ejemplo04: Screens("ej04")
    object Ejemplo04a: Screens("ej04a")
    object Ejemplo04b: Screens("ej04b")
    object Ejemplo04c: Screens("ej04c")

}
