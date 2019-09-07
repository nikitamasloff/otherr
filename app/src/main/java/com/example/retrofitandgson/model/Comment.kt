package com.example.retrofitandgson.model

import com.google.gson.annotations.SerializedName

data class Comment(
    val postId: Int,
    val id: Int,
    val email: String,
    @SerializedName("name") val title: String,
    @SerializedName("body") val description: String
)