package com.petplace.thatpetplace.auth.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/register")
    suspend fun register(
        @Body registrationPayload: RegistrationPayload
    ) : ApiResponse
}