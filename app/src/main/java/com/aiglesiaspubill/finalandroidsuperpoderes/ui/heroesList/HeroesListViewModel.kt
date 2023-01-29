package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _herosList = MutableStateFlow(emptyList<Hero>())
    val herosList: MutableStateFlow<List<Hero>> get() = _herosList

    private fun setValueOnMainThreadHerosDataWrapper(value: List<Hero>) {
        viewModelScope.launch(Dispatchers.Main) {
            _herosList.value = value
        }
    }

    init {
        getHeros()
    }

    fun getHeros() {
        viewModelScope.launch {
            repository.getHeroes().flowOn(Dispatchers.IO).collect() {
                setValueOnMainThreadHerosDataWrapper(it)
            }
        }
    }

}
