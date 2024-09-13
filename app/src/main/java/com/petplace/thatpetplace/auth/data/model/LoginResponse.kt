package com.petplace.thatpetplace.auth.data.model

data class LoginResponse(
    val message: String,
    val token: String,
    val userId: String,
    val first_name: String
)