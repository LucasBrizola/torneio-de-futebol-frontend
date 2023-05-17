package com.brizola.torneiofut.match.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brizola.torneiofut.match.usecase.MatchUsecase
import kotlinx.coroutines.launch

class NewMatchViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val matchUseCase: MatchUsecase by lazy {
        MatchUsecase()
    }

    fun validateFields(
        name: String?, team1: String?, team2: String?, goal1: String?, goal2: String?,
        hour: String?
    ) {
        viewModelScope.launch {
            if (name.isNullOrEmpty() || team1.isNullOrEmpty() || team2.isNullOrEmpty() || hour.isNullOrEmpty()
                || goal1.isNullOrEmpty() || goal2.isNullOrEmpty()
            ) {
                state.value = ViewState.ShowErrorNull
            } else {
                val goals = concatGoals(goal1, goal2)
                matchUseCase.saveMatch(
                    name, team1, team2, goals,
                    hour
                )
                state.value = ViewState.ShowSuccess
            }
        }
    }

    fun concatGoals(goal1: String, goal2:String): String{
        return goal1.plus("x").plus(goal2)
    }
}

sealed class ViewState {
    object ShowErrorNull : ViewState()
    object ShowSuccess : ViewState()
}