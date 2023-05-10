package com.brizola.torneiofut.login.domain

import com.brizola.torneiofut.login.data.local.Match
import com.brizola.torneiofut.login.data.remote.RemoteLoginDatasource

class UserUsecase {
    private val remoteLoginDataSource: RemoteLoginDatasource by lazy {
        RemoteLoginDatasource()
    }

    suspend fun login(name: String, password: String) : Boolean{
        return remoteLoginDataSource.login(user = Match(name, password))
    }
}