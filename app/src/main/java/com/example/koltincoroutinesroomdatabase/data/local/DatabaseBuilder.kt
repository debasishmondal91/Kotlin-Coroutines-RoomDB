package com.example.koltincoroutinesroomdatabase.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase? {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDatabase(context)
            }
        }

        return INSTANCE
    }

    private fun buildRoomDatabase(context: Context): AppDatabase? =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "user-database"
        ).build()
}