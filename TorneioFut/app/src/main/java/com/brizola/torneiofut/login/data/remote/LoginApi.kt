package com.brizola.torneiofut.login.data.remote

import com.brizola.torneiofut.login.data.local.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/user")
    suspend fun login(
        @Body user : User
    ): Response<Boolean>
}