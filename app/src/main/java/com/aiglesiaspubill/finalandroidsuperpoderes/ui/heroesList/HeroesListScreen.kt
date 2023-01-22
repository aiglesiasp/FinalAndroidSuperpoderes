package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.compose.foundation.Image
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
fun HeroesListScreen(viewModel: HeroesListViewModel = hiltViewModel(), onNavigateToDetail: () -> (Unit) = {}) {
    val success = viewModel.state.observeAsState(false)

    LaunchedEffect(key1 = success.value) {
        if (success.value) {
            onNavigateToDetail()
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        val heros = viewModel.heros.collectAsState()
        MyLazyColumn(heros = heros.value[0].data.results ,viewModel = viewModel)
    }
}

@Composable
fun MyLazyColumn(heros: List<Hero> = emptyList(), viewModel: HeroesListViewModel) {

    LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        itemsIndexed(heros) {_, hero ->
            Item(hero.name, hero.thumbnail.path) {
                viewModel.navigateToDetail()
            }
        }
    }
}



@Composable
fun Item(name: String = "Goku", photo: String = "", onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberAsyncImagePainter(model = photo),
            contentDescription = "Hero Photo",
            modifier = Modifier.size(100.dp)
        )
        Text(text = name, Modifier.padding(8.dp), style = MaterialTheme.typography.h5)
    }
}