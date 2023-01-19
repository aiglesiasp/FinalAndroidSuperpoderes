package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _heros = MutableLiveData<List<Hero>>()
    val heros: LiveData<List<Hero>> get() = _heros

    private fun setValueOnMainThread(value: List<Hero>) {
        viewModelScope.launch(Dispatchers.Main) {
            _heros.value = value
        }
    }
    init {
        val hero = listOf(Hero("","Aitor",""),
            Hero("","Paco",""),
            Hero("","Manolo",""),
            Hero("","Raul",""))

        setValueOnMainThread(hero)
    }

    }
/*
    private fun getHeros() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getHeros()
            }

            _heros.value = result
        }
    }*/
