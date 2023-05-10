package com.brizola.torneiofut.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brizola.torneiofut.login.domain.UserUsecase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val usecase: UserUsecase by lazy {
        UserUsecase()
    }

    fun loginUser(name: String, password: String) {
        viewModelScope.launch {
            val loginSuccess = usecase.login(name, password)
            if (loginSuccess == true) {

                state.value = ViewState.ShowSuccess
            } else
                state.value = ViewState.ShowError
        }
    }
}

sealed class ViewState {
    object ShowSuccess : ViewState()
    object ShowError : ViewState()
}