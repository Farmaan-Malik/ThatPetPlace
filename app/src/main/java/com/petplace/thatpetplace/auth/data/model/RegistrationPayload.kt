package com.petplace.thatpetplace.auth.data.model

data class RegistrationPayload(
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val phone_number: String

)