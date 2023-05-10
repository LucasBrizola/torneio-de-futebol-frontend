package com.brizola.torneiofut.match.usecase

import android.util.Log
import com.brizola.torneiofut.login.data.local.Match
import com.brizola.torneiofut.match.domain.data.remote.RemoteMatchDatasource

class MatchUsecase {

    private val remoteMatchDatasource: RemoteMatchDatasource by lazy {
        RemoteMatchDatasource()
    }

    suspend fun listAll(): List<Match>{
        val listMatches = remoteMatchDatasource.getListAll()
        Log.e("Match", "list Matches: " + "${listMatches}")
        return listMatches
    }
}