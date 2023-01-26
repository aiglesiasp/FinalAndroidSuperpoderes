package com.aiglesiaspubill.finalandroidsuperpoderes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.data.mappers.Mappers
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _hero = MutableStateFlow(Hero(0, "", "", Thumbnail("", "")))
    val hero: MutableStateFlow<Hero> get() = _hero

    private fun setValueOnMainThreadHeros(value: Hero) {
        viewModelScope.launch(Dispatchers.Main) {
            _hero.value = value
        }
    }


    fun getHeroDetail(id: Int) {
        viewModelScope.launch {
            repository.getHeroDetail(id).flowOn(Dispatchers.IO).collect() {
                val hero = it.first()
                setValueOnMainThreadHeros(Mappers().mapRemoteToPresentationOneHero(hero))
            }
        }
    }



}