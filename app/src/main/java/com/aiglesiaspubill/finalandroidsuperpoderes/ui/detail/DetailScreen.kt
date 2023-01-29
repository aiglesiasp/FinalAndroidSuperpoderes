package com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie

@Composable
fun DetailScreen(id: Int, viewModel: DetailViewModel= hiltViewModel()) {

    LaunchedEffect(key1 = id) {
        initCalling(viewModel, id)
    }
    val hero = viewModel.hero.collectAsState().value
    val series = viewModel.serie.collectAsState().value
    val comics = viewModel.comic.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetHero(hero)
        SetSeries(series)
        SetComics(comics)
    }
}

@Composable
fun SetImage(photo: String = "" ) {
    val imageModifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .absolutePadding(top = 10.dp, bottom = 10.dp)

    AsyncImage(model = photo, contentDescription = "hero photo", modifier = imageModifier, contentScale = ContentScale.Crop)
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
fun SetDescription(description: String = "VACIA") {
    Text(
        text = "DESCRIPCION: $description",
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(bottom = 10.dp, left = 10.dp),
        textAlign = TextAlign.Start,
        textDecoration = TextDecoration.None,
        color = Color.Black,
        fontSize = 12.sp
    )
}

@Composable
fun SetHero(heroList: List<Hero> = emptyList()) {
    SetImage((heroList.getOrNull(0)?.thumbnail?.path ?: "") + "." + (heroList.getOrNull(0)?.thumbnail?.extension
        ?: ""))
    heroList.getOrNull(0)?.let { SetName(it.name) }
    heroList.getOrNull(0)?.let { it.description?.let { it1 -> SetDescription(it1) } }
}
@Composable
fun SetSeries(seriesList: List<Serie> = emptyList()) {
    SetName("SERIE")
    seriesList.getOrNull(0)?.let { SetName(it.title) }
    seriesList.getOrNull(0)?.let { it.description?.let { it1 -> SetDescription(it1) } }
}

@Composable
fun SetComics(comicList: List<Comic> = emptyList()) {

    SetName("COMIC")
    comicList.getOrNull(0)?.let { SetName(it.title) }
    comicList.getOrNull(0)?.let { it.description?.let { it1 -> SetDescription(it1) } }
}

private fun initCalling(viewModel: DetailViewModel, id: Int) {
    viewModel.getHeroDetail(id)
    viewModel.getHeroSeries(id)
    viewModel.getHeroComics(id)
}