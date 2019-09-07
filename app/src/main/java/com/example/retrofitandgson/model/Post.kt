package com.example.retrofitandgson.model

import com.google.gson.annotations.SerializedName

data class Post(
    val userId: Int,
    val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val description: String
)