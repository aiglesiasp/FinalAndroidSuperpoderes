package com.aiglesiaspubill.finalandroidsuperpoderes.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aiglesiaspubill.finalandroidsuperpoderes.R

@Preview(showSystemUi = true)
@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), onNavigateToList: () -> (Unit) = {}) {

    val success = viewModel.loginSucces.observeAsState(false)

    LaunchedEffect(key1 = success.value) {
        if (success.value) {
            onNavigateToList()
        }
    }
    SetImage()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            LoginButton() {
                viewModel.navigateToList()
            }
        }
    }
}

@Composable
fun SetImage() {
    val imageModifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)

    Image(
        painter = painterResource(id = R.drawable.ic_fondo_pantalla_capitan_america),
        contentDescription = "Fondo pantalla",
        contentScale = ContentScale.Crop,
        modifier = imageModifier
    )
}

//CREANDO BOTON
@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(100.dp)
    ) {
        Text(
            text = "ENTRAR",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.None,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


