package com.aiglesiaspubill.finalandroidsuperpoderes.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aiglesiaspubill.finalandroidsuperpoderes.R

@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {
    val viewModel = LoginViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
       Title()
        LoginForm(viewModel= viewModel)

    }
}




//TITULO DE LA APP
@Preview(showSystemUi = true)
@Composable
fun Title() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Title",
            Modifier
                .border(BorderStroke(3.dp, Color.Black), shape = CircleShape)
                .background(Color.Green)
        )

    }
}


//CREANDO BOTON
@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(8.dp)) {
        Text(text = "Login")
    }
}

@Composable
fun FormFieldPlaceHolder(placeholder: String) {
    Text(text = placeholder)
}

@Composable
fun FormField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            FormFieldPlaceHolder(placeholder)
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

    )
}

//@Preview(showBackground = true)
@Composable
fun FormFieldPreview() {
    FormField(
        "Email",
        {},
        placeholder = "Password",
        true,
    )
}

//CREO PACK DE LOGIN
@Composable
fun LoginForm(extended: Boolean = true, viewModel: LoginViewModel) {
    Column(
        Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //var email by rememberSaveable {
        //    mutableStateOf("")
        //}
        //var password by rememberSaveable {
        //    mutableStateOf("")
        //}

        var email = ""
        var password = ""

        FormField(value = email, onValueChange = { email=it }, placeholder = "Email")
        if(extended) {
            FormField(value = password, onValueChange = {password = it}, placeholder = "Password")
        }
        LoginButton {
            //TODO LLAMADA AL VIEWMODEL LOGIN BUTTON
        }
    }
}
