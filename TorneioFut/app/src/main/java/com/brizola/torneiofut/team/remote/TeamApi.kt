package com.brizola.torneiofut.team.remote

import com.brizola.torneiofut.team.domain.data.Team
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TeamApi {

    @POST("/teams")
    suspend fun saveTeam(@Body team: Team) : Response<Team>
}