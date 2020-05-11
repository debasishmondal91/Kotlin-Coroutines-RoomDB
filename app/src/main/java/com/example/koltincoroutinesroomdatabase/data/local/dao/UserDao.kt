package com.example.koltincoroutinesroomdatabase.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.koltincoroutinesroomdatabase.data.local.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getUsers(): List<User>

    @Query("SELECT * FROM User Where id = :userId")
    suspend fun getUser(userId: Int): User

    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insetAllUser(users: List<User>)

}