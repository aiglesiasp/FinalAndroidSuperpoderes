package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _heros = MutableStateFlow(emptyList<HeroDataWrapper>())
    val heros: MutableStateFlow<List<HeroDataWrapper>> get() = _heros

    private val _state = MutableLiveData<Boolean>()
    val state: LiveData<Boolean> get() = _state

    private fun setValueOnMainThreadHeros(value: List<HeroDataWrapper>) {
        viewModelScope.launch(Dispatchers.Main) {
            _heros.value = value
        }
    }

    private fun setValueOnMainThreadState(value: Boolean) {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = value
        }
    }

    init {
        getHeros()
    }


    fun getHeros() {
        viewModelScope.launch {
           repository.getHeroes().flowOn(Dispatchers.IO).collect() {
               setValueOnMainThreadHeros(it)
           }
        }
    }

    fun navigateToDetail() {
        setValueOnMainThreadState(true)
    }
}
