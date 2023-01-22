package com.aiglesiaspubill.finalandroidsuperpoderes.ui.login


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aiglesiaspubill.finalandroidsuperpoderes.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _loginSuccess = MutableStateFlow(false)
    val loginSucces: StateFlow<Boolean> get() = _loginSuccess

    private fun setValueOnMainThread(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _loginSuccess.value = value
        }
    }

    fun getLogin() {
        viewModelScope.launch {
            val success = withContext(Dispatchers.IO) {
                repository.getLogin()
            }
            setValueOnMainThread(success)
        }
    }
}
