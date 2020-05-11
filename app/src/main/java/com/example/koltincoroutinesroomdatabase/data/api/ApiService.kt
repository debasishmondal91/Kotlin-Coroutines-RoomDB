package com.example.koltincoroutinesroomdatabase.data.api

import com.example.koltincoroutinesroomdatabase.data.model.ApiUser
import com.example.koltincoroutinesroomdatabase.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<ApiUser>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse
}