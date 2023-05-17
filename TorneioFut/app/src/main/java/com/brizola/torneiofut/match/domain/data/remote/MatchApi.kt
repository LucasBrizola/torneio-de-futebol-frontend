package com.brizola.torneiofut.match.domain.data.remote

import com.brizola.torneiofut.match.domain.data.local.Match
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MatchApi {

    @GET("/matches")
    suspend fun getAllMatches() : Response<List<Match>>

    @POST("/matches")
    suspend fun saveMatch(
        @Body match: Match
    ) : Response<Match?>
}