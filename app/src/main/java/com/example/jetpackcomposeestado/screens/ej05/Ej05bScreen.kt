package com.example.jetpackcomposeestado.screens.ej05


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Ej05bScreen() {

    var cuenta1 by rememberSaveable { mutableStateOf(startCountDefault) }
    var cuenta2 by rememberSaveable { mutableStateOf(startCountDefault) }
    var cuentaG by rememberSaveable { mutableStateOf(startCountDefault) }

    var incremento1 by rememberSaveable { mutableStateOf(incrementDefault) }
    var incremento2 by rememberSaveable { mutableStateOf(incrementDefault) }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        BloqueContador(buttonText = "Contador 1",
            cuenta = cuenta1,
            incremento = incremento1,
            onClick = {
                cuenta1 += incremento1
                cuentaG += incremento1
            },
            onIncrementChange = {
                incremento1 = it.toIntOrNull() ?: incrementDefault
                if (incremento1 > 99 || incremento1 < 1) incremento1 = 1
            },
            onResetCount = { cuenta1 = 0 }
        )
        BloqueContador(buttonText = "Contador 2",
            cuenta = cuenta2,
            incremento = incremento2,
            onClick = {
                cuenta2 += incremento2
                cuentaG += incremento2
            },
            onIncrementChange = {
                incremento2 = it.toIntOrNull() ?: incrementDefault
                if (incremento2 > 99 || incremento2 < 1) incremento2 = 1
            },
            onResetCount = { cuenta2 = 0 }
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Global")
            Spacer(Modifier.width(10.dp))
            Text(text = cuentaG.toString())
            Spacer(Modifier.width(6.dp))
            Box(Modifier.clickable { cuentaG = 0 }) {
                Image(painter = painterResource(id = android.R.drawable.ic_menu_delete),
                    contentDescription = "Borrar")
            }
        }
    }
}

@Composable
fun BloqueContador(
    buttonText: String,
    cuenta: Int,
    incremento: Int,
    onClick: () -> Unit,
    onIncrementChange: (String) -> Unit,
    onResetCount: () -> Unit,
) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = onClick) {
                Text(text = "$buttonText  ($cuenta)")
            }
            Spacer(Modifier.width(10.dp))
            Text(text = cuenta.toString())
            Spacer(Modifier.width(6.dp))
            Box(Modifier.clickable(onClick = { onResetCount })) {
                Image(painter = painterResource(id = android.R.drawable.ic_menu_delete),
                    contentDescription = "Borrar")
            }
        }
        Row(Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom) {
            Text(text = "Incremento: ")
            BasicTextField(
                value = incremento.toString(),
                onValueChange = onIncrementChange,
                Modifier
                    .width(30.dp)
                    .height(28.dp),
                textStyle = LocalTextStyle.current.copy(
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.End), // (2)
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // (1)
                decorationBox = { decorationBox(it) }
            )
        }
    }
}

