package com.brizola.torneiofut.login.data.remote

import android.util.Log
import com.brizola.torneiofut.login.data.local.User
import com.brizola.torneiofut.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteLoginDatasource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(user: User): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val login = service.login(user = user)
                if (login.isSuccessful) {
                    login.body()
                } else {
                    false
                }
            } catch (ex: Exception) {
                Log.e("LoginProblem", ex.message ?: "Login não realizado")
                false
            }!!
        }
    }

}