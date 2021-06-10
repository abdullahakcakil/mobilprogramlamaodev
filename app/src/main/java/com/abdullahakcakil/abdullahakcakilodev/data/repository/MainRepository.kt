package com.abdullahakcakil.abdullahakcakilodev.data.repository

import com.abdullahakcakil.abdullahakcakilodev.data.api.RetrofitBuilder

class MainRepository {
    suspend fun getUsers() = RetrofitBuilder.api.getUsers()
}