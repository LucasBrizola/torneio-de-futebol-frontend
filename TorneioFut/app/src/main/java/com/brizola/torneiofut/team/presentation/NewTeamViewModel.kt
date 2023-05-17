package com.brizola.torneiofut.team.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brizola.torneiofut.player.Player
import com.brizola.torneiofut.team.usecase.TeamUsecase
import kotlinx.coroutines.launch

class NewTeamViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val players: ArrayList<Player> = ArrayList<Player>()

    private val teamUsecase: TeamUsecase by lazy {
        TeamUsecase()
    }

    fun createNewTeam(
        nameTeam: String?,
        num1: String?,
        player1: String?,
        num2: String?,
        player2: String?,
        num3: String?,
        player3: String?,
        num4: String?,
        player4: String?,
        num5: String?,
        player5: String?,
        num6: String?,
        player6: String?,
        num7: String?,
        player7: String?,
        num8: String?,
        player8: String?,
        num9: String?,
        player9: String?,
        num10: String?,
        player10: String?,
    ) {
        viewModelScope.launch {
            if (nameTeam.isNullOrEmpty()) {
                state.value = ViewState.ShowErrorNameTeam
            } else {
                if (num1.isNullOrEmpty() || num2.isNullOrEmpty() || num3.isNullOrEmpty() ||
                    num4.isNullOrEmpty() || num5.isNullOrEmpty()
                    || player1.isNullOrEmpty() || player2.isNullOrEmpty() ||
                    player3.isNullOrEmpty() || player4.isNullOrEmpty() ||
                    player5.isNullOrEmpty()
                ) {
                    state.value = ViewState.ShowErrorMinPlayer
                } else {
                    addPlayer(num1, player1)
                    addPlayer(num2, player2)
                    addPlayer(num3, player3)
                    addPlayer(num4, player4)
                    addPlayer(num5, player5)
                    addPlayer(num6!!, player6!!)
                    addPlayer(num7!!, player7!!)
                    addPlayer(num8!!, player8!!)
                    addPlayer(num9!!, player9!!)
                    addPlayer(num10!!, player10!!)
                    if (players.size < 5) {
                        state.value = ViewState.ShowErrorMinPlayer
                    } else
                        teamUsecase.saveTeam(nameTeam, players)
                    state.value = ViewState.ShowSuccess
                }
            }
        }
    }

    private fun addPlayer(num: String, player: String) {
        if (!num.isNullOrEmpty() || !player.isNullOrEmpty()) {
            players.add(Player(player, Integer.parseInt(num)))
        }
    }
}

sealed class ViewState {
    object ShowErrorMinPlayer : ViewState()
    object ShowErrorNameTeam : ViewState()
    object ShowSuccess : ViewState()
}