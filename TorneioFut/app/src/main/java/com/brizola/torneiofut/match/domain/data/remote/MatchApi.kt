package com.brizola.torneiofut.match.domain.data.remote

import com.brizola.torneiofut.login.data.local.Match
import retrofit2.Response
import retrofit2.http.GET

interface MatchApi {

    @GET("/matches")
    suspend fun getAllCharacters() : Response<List<Match>>
}