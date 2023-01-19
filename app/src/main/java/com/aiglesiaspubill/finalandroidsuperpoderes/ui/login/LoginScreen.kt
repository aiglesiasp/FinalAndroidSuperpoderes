package com.aiglesiaspubill.finalandroidsuperpoderes.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Preview(showSystemUi = true)
@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel(), onNavigateToList: () -> (Unit) = {}) {

    val success = viewModel.loginSucces.observeAsState(false)

    LaunchedEffect(key1 = success.value) {
        if(success.value) {
            onNavigateToList()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth().background(Color.Black)) {
            LoginButton() {
                viewModel.navigateToList()
            }
        }
    }
}



//CREANDO BOTON
@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(8.dp)) {
        Text(text = "Login")
    }
}

