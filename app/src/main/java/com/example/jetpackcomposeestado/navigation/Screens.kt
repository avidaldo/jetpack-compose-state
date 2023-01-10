package com.example.jetpackcomposeestado.navigation

sealed class Screens(val route: String){
    object MainScreen: Screens("initial_screen")

    object Ejemplo01: Screens("ej01")

    object Ejemplo02: Screens("ej02")

    object Ejemplo03: Screens("ej03")
    object Ejemplo03a: Screens("ej03a")
    object Ejemplo03b: Screens("ej03b")

    object Ejemplo04: Screens("ej04")
    object Ejemplo04a: Screens("ej04a")
    object Ejemplo04b: Screens("ej04b")
    object Ejemplo04c: Screens("ej04c")
    object Ejemplo04d: Screens("ej04d")



    object Ejemplo05: Screens("ej05")
    object Ejemplo06: Screens("ej06")
    object Ejemplo07: Screens("ej07")
    object Ejemplo08: Screens("ej08")

}
