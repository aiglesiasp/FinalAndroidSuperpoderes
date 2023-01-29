package com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Comic
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Serie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _hero = MutableStateFlow(emptyList<Hero>())
    val hero: MutableStateFlow<List<Hero>> get() = _hero

    private fun setValueOnMainThreadHeros(value: List<Hero>) {
        viewModelScope.launch(Dispatchers.Main) {
            _hero.value = value
        }
    }

    private val _seriesList = MutableStateFlow(emptyList<Serie>())
    val serie: MutableStateFlow<List<Serie>> get() = _seriesList

    private fun setValueOnMainThreadSeries(value: List<Serie>) {
        viewModelScope.launch(Dispatchers.Main) {
            _seriesList.value = value
        }
    }

    private val _comicsList = MutableStateFlow(emptyList<Comic>())
    val comic: MutableStateFlow<List<Comic>> get() = _comicsList

    private fun setValueOnMainThreadComics(value: List<Comic>) {
        viewModelScope.launch(Dispatchers.Main) {
            _comicsList.value = value
        }
    }


    fun getHeroDetail(id: Int) {
        viewModelScope.launch {
            repository.getHeroDetail(id).flowOn(Dispatchers.IO).collect() {
                setValueOnMainThreadHeros(it)
            }
        }
    }

    fun getHeroSeries(id: Int) {
        viewModelScope.launch {
            repository.getHeroSeries(id).flowOn(Dispatchers.IO).collect() {
                setValueOnMainThreadSeries(it)
            }
        }
    }

    fun getHeroComics(id: Int) {
        viewModelScope.launch {
            repository.getHeroComics(id).flowOn(Dispatchers.IO).collect() {
                setValueOnMainThreadComics(it)
            }
        }
    }


}