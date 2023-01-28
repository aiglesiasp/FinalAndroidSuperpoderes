package com.aiglesiaspubill.finalandroidsuperpoderes.ui.heroesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroDataWrapper
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.HeroRemote
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Hero
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroesListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _state = MutableStateFlow(false)
    val state: StateFlow<Boolean> get() = _state

    private val _herosList = MutableStateFlow(emptyList<Hero>())
    val herosList: MutableStateFlow<List<Hero>> get() = _herosList

    private fun setValueOnMainThreadHerosDataWrapper(value: List<Hero>) {
        viewModelScope.launch(Dispatchers.Main) {
            _herosList.value = value
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
                setValueOnMainThreadHerosDataWrapper(it)
            }
        }
    }

}
