package com.brizola.torneiofut.team.remote

import android.util.Log
import com.brizola.torneiofut.team.data.Team
import com.brizola.torneiofut.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteTeamDataSource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(TeamApi::class.java)

    suspend fun saveTeamApi(team: Team) {
        return withContext(Dispatchers.IO) {
            try {
                val teamResponse = service.saveTeam(team)
                if (teamResponse.isSuccessful) {
                    Log.e("TeamDataSource", "body from response: " + "${teamResponse.body()}")
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("TeamDataSource", ex.message ?: "time não salvo")
                null
            }
        }
    }
}