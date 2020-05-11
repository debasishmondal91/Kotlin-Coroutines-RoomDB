package com.example.koltincoroutinesroomdatabase.data.local

import com.example.koltincoroutinesroomdatabase.data.local.entity.User

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getUsers()

    override suspend fun getUser(userId: Int): User = appDatabase.userDao().getUser(userId)

    override suspend fun insertAllUSer(users: List<User>) =
        appDatabase.userDao().insetAllUser(users)

    override suspend fun insertUser(user: User) = appDatabase.userDao().insertUser(user)

}