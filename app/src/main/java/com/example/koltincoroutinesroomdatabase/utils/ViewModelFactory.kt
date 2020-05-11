package com.example.koltincoroutinesroomdatabase.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.koltincoroutinesroomdatabase.data.api.ApiHelper
import com.example.koltincoroutinesroomdatabase.data.local.DatabaseHelper
import com.example.koltincoroutinesroomdatabase.ui.main.MainViewModel
import com.example.koltincoroutinesroomdatabase.ui.userdetails.UserDetailsViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                apiHelper,
                dbHelper
            ) as T
        } else if (modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            return UserDetailsViewModel(
                apiHelper,
                dbHelper
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}