package com.example.koltincoroutinesroomdatabase.data.local

import com.example.koltincoroutinesroomdatabase.data.local.entity.User

interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun getUser(userId: Int): User

    suspend fun insertAllUSer(users: List<User>)

    suspend fun insertUser(user: User)
}