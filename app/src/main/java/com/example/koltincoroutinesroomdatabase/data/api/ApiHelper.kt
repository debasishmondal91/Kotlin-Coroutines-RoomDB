package com.example.koltincoroutinesroomdatabase.data.api

import com.example.koltincoroutinesroomdatabase.data.model.ApiUser
import com.example.koltincoroutinesroomdatabase.data.model.UserResponse

interface ApiHelper {

    suspend fun getUsers(): List<ApiUser>

    suspend fun getUser(userId: Int): UserResponse
}