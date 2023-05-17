package com.brizola.torneiofut.match.domain.data.remote

import android.util.Log
import com.brizola.torneiofut.match.domain.data.local.Match
import com.brizola.torneiofut.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteMatchDatasource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(MatchApi::class.java)

    suspend fun getListAll(): List<Match> {
        try {
            val match = service.getAllMatches()
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

    suspend fun saveMatchApi(match: Match): Match? {
        return withContext(Dispatchers.IO) {
            try {
                val matchResponse = service.saveMatch(match)
                if (matchResponse.isSuccessful) {
                    Log.e("MatchDataSource", "body from response: " + "${matchResponse.body()}")
                    matchResponse.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("MatchDataSource", ex.message ?: "match não salvo")
                null
            }
        }
    }
}