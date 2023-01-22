package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import android.content.ClipData
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero

@Preview(showSystemUi = true)
@Composable
fun HeroesListScreen(
    viewModel: HeroesListViewModel = hiltViewModel(),
    onNavigateToDetail: () -> (Unit) = {}
) {
    val success = viewModel.hero.collectAsState()

    LaunchedEffect(key1 = success.value) {
        if (success.value) {
            onNavigateToDetail()
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        val heros = viewModel.heros.collectAsState()
        MyLazyColumn(heros = heros.value, viewModel = viewModel)
    }
}

@Composable
fun MyLazyColumn(heros: List<Hero> = emptyList(), viewModel: HeroesListViewModel) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(heros) { _, hero ->
            Item(hero, viewModel)
        }
    }
}

@Composable
fun Item(hero: Hero, viewModel: HeroesListViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable { viewModel.navigateToDetail() }) {
        Image(
            painter = rememberAsyncImagePainter(model = hero.photo),
            contentDescription = "Hero Photo",
            modifier = Modifier.size(100.dp)
        )
        Text(text = hero.name, Modifier.padding(8.dp), style = MaterialTheme.typography.h5)
    }
}