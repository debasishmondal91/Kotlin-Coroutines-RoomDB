package com.example.koltincoroutinesroomdatabase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koltincoroutinesroomdatabase.data.api.ApiHelper
import com.example.koltincoroutinesroomdatabase.data.local.DatabaseHelper
import com.example.koltincoroutinesroomdatabase.data.local.entity.User
import com.example.koltincoroutinesroomdatabase.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val apiHelper: ApiHelper, private val databaseHelper: DatabaseHelper) :
    ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()

    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val userFromDb = databaseHelper.getUsers()
                if (userFromDb.isEmpty()) {
                    val usersFromApi = apiHelper.getUsers()
                    val userInsertToDb = mutableListOf<User>()
                    for (apiUser in usersFromApi) {
                        val users = User(
                            apiUser.id,
                            apiUser.name,
                            apiUser.createdAt,
                            apiUser.avatar
                        )
                        userInsertToDb.add(users)
                    }
                    databaseHelper.insertAllUSer(userInsertToDb)
                    users.postValue(Resource.success(userInsertToDb))

                } else {
                    users.postValue(Resource.success(userFromDb))
                }

            } catch (e: Exception) {
                users.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }
}
