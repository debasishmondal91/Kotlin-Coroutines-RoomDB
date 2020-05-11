package com.example.koltincoroutinesroomdatabase.data.api

import com.example.koltincoroutinesroomdatabase.data.model.ApiUser
import com.example.koltincoroutinesroomdatabase.data.model.UserResponse

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers(): List<ApiUser> = apiService.getUsers()

    override suspend fun getUser(userId: Int): UserResponse = apiService.getUser(userId)
}