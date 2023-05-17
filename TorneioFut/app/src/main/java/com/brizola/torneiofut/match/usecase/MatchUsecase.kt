package com.brizola.torneiofut.match.usecase

import com.brizola.torneiofut.match.domain.data.local.Match
import com.brizola.torneiofut.match.domain.data.remote.RemoteMatchDatasource

class MatchUsecase {

    private val remoteMatchDatasource: RemoteMatchDatasource by lazy {
        RemoteMatchDatasource()
    }

    suspend fun listAll(): List<Match> {
        return remoteMatchDatasource.getListAll()
    }

    suspend fun saveMatch(
        name: String, team1: String, team2: String, goals: String, hour: String
    ) {
        remoteMatchDatasource.saveMatchApi(match = Match(name, team1, team2, hour, goals))

    }
}