package com.example.retrofitandgson.model

data class User(
    val id: Int? = null,
    val name: String,
    val email: String,
    val address: Address? = null,
    val company: Company? = null
)