package com.example.koltincoroutinesroomdatabase.ui.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koltincoroutinesroomdatabase.data.api.ApiHelper
import com.example.koltincoroutinesroomdatabase.data.local.DatabaseHelper
import com.example.koltincoroutinesroomdatabase.data.local.entity.User
import com.example.koltincoroutinesroomdatabase.utils.Resource
import kotlinx.coroutines.launch

class UserDetailsViewModel(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModel() {

    private val userDetails = MutableLiveData<Resource<User>>()

    fun getUserDetails(userId: Int) {
        try {
            viewModelScope.launch {
                val detailsFromDb = dbHelper.getUser(userId)
                if (detailsFromDb.name.isBlank()) {
                    val detailsFromApi = apiHelper.getUser(userId)
                    val user = User(
                        detailsFromApi.id,
                        detailsFromApi.name,
                        detailsFromApi.createdAt,
                        detailsFromApi.avatar
                    )
                    dbHelper.insertUser(user)
                    userDetails.postValue(Resource.success(user))
                } else {
                    userDetails.postValue(Resource.success(detailsFromDb))
                }
            }
        } catch (e: Exception) {
            userDetails.postValue(
                Resource.error(
                    "Something Went Wrong, Our Best Minds Are Working On That",
                    null
                )
            )
        }
    }

    fun getUserDetails(): LiveData<Resource<User>> {
        return userDetails
    }
}