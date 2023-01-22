package com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.aiglesiaspubill.finalandroidsuperpoderes.R
import com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList.HeroesListViewModel

@Composable
fun DetailScreen(name: String,photo: String,description: String, viewModel: DetailViewModel= hiltViewModel()) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetImage(photo)
        SetName(name)
        SetDescription(description)
    }
}

@Composable
fun SetImage(photo: String = "" ) {
    val imageModifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .absolutePadding(top = 10.dp, bottom = 10.dp)

    Image(
        painter = rememberAsyncImagePainter(model = photo),
        contentDescription = "Hero Photo",
        contentScale = ContentScale.Crop,
        modifier = imageModifier
    )
}

@Composable
fun SetName(name: String = "Goku") {
    Text(
        text = name,
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(bottom = 10.dp, left = 10.dp),
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.None,
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SetDescription(description: String = "mmamamamammmamammammammmama") {
    Text(
        text = description,
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(bottom = 10.dp, left = 10.dp),
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.None,
        color = Color.Black,
        fontSize = 15.sp
    )
}