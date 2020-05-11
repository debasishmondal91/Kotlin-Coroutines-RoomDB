package com.example.koltincoroutinesroomdatabase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koltincoroutinesroomdatabase.data.local.dao.UserDao
import com.example.koltincoroutinesroomdatabase.data.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}