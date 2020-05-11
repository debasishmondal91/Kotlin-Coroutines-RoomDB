package com.example.koltincoroutinesroomdatabase.data.model

import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("avatar")
    val avatar: String = ""
)