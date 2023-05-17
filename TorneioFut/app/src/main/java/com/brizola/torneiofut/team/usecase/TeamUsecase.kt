package com.brizola.torneiofut.team.usecase

import com.brizola.torneiofut.player.Player
import com.brizola.torneiofut.team.domain.data.Team
import com.brizola.torneiofut.team.remote.RemoteTeamDataSource

class TeamUsecase {

    private val remoteTeamDataSource: RemoteTeamDataSource by lazy {
        RemoteTeamDataSource()
    }

    suspend fun saveTeam(teamName: String, players: ArrayList<Player>){
        val team = Team(teamName, players)
        remoteTeamDataSource.saveTeamApi(team)
    }
}