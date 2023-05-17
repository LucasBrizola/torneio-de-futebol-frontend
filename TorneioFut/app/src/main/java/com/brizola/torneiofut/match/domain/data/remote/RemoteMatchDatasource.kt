package com.brizola.torneiofut.match.domain.data.remote

import android.util.Log
import com.brizola.torneiofut.login.data.local.Match
import com.brizola.torneiofut.webservice.RetrofitNetworkClient

class RemoteMatchDatasource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(MatchApi::class.java)

    suspend fun getListAll(): List<Match> {
        try {
            val match = service.getAllCharacters()
            if (match.isSuccessful) {
                Log.e("MatchDataSource", "body from response: " + "${match.body()}")
                return match.body().orEmpty()
            } else {
                return listOf()
            }
        } catch (ex: Exception) {
            Log.e("match", ex.message ?: "partidas não encontradas")
            return listOf()
        }
    }
}