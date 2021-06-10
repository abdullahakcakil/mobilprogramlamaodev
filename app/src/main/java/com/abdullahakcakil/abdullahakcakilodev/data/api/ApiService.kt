package com.abdullahakcakil.abdullahakcakilodev.data.api

import com.abdullahakcakil.abdullahakcakilodev.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():Response<MutableList<User>>
}