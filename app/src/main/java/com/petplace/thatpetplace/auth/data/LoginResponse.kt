package com.petplace.thatpetplace.auth.data

data class LoginResponse(
    val message: String,
    val token: String,
    val userId: String
)