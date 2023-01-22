package com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiglesiaspubill.finalandroidsuperpoderes.R

@Preview(showSystemUi = true)
@Composable
fun DetailScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetImage()
        SetName()
        SetDescription()
    }
}

@Composable
private fun SetImage(id: Int = R.drawable.ic_fondo_pantalla_capitan_america ) {
    val imageModifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .absolutePadding(top = 10.dp, bottom = 10.dp)

    Image(
        painter = painterResource(id = id),
        contentDescription = "Fondo pantalla",
        contentScale = ContentScale.Crop,
        modifier = imageModifier
    )
}

@Composable
private fun SetName(name: String = "Goku") {
    Text(
        text = name,
        modifier = Modifier.fillMaxWidth().absolutePadding(bottom = 10.dp, left = 10.dp),
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.None,
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun SetDescription(description: String = "mmamamamammmamammammammmama") {
    Text(
        text = description,
        modifier = Modifier.fillMaxWidth().absolutePadding(bottom = 10.dp, left = 10.dp),
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.None,
        color = Color.Black,
        fontSize = 15.sp
    )
}