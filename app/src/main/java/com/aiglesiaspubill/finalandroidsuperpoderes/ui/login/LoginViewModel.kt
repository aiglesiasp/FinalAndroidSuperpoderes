package com.aiglesiaspubill.finalandroidsuperpoderes.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSucces: LiveData<Boolean> get() = _loginSuccess

    private fun setValueOnMainThread(value: Boolean) {
        viewModelScope.launch(Dispatchers.Main) {
            _loginSuccess.value = value
        }
    }

    fun navigateToList() {
        setValueOnMainThread(true)
        }
    }
