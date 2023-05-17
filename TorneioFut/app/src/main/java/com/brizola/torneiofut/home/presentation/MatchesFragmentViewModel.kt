package com.brizola.torneiofut.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brizola.torneiofut.match.domain.data.local.Match
import com.brizola.torneiofut.match.usecase.MatchUsecase
import kotlinx.coroutines.launch

class MatchesFragmentViewModel : ViewModel(){
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val matchUseCase: MatchUsecase by lazy {
        MatchUsecase()
    }

    fun populateRecyclerView() {
        viewModelScope.launch {
            val matchList: List<Match> =
                matchUseCase.listAll()
            if (matchList.isEmpty()) {
                state.value = ViewState.ShowListEmpty
                Log.e("MatchError", "matchEmpty is empty")
            } else
                state.value = ViewState.ShowMatchList(matchList)
        }
    }

}

sealed class ViewState {
    data class ShowMatchList(val matchList: List<Match>) : ViewState()
    object ShowListEmpty : ViewState()
}