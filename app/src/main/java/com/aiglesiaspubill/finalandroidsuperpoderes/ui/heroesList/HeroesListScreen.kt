package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.navigation.Screens

@Composable
fun HeroesListScreen(
    navController: NavController,
    viewModel: HeroesListViewModel = hiltViewModel()
) {

    val heros = viewModel.herosList.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver atras",
                modifier = Modifier.clickable { navController.popBackStack() })
            Text(text = "PANTALLA DE HEROES")
        }
    }) {
        MyLazyColumn(heros = heros.value, navController)
    }
}

@Composable
fun MyLazyColumn(heros: List<Hero> = emptyList(), navController: NavController) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(heros) { _, hero ->
            Item(hero, navController)
        }
    }
}

@Composable
fun Item(hero: Hero, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable { navController.navigate(Screens.Detail.route + "/${hero.id}") }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "${hero.thumbnail.path}.${hero.thumbnail.extension}"),
            contentDescription = "Hero Photo",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = hero.name, Modifier.padding(8.dp), style = MaterialTheme.typography.subtitle1)
    }
}