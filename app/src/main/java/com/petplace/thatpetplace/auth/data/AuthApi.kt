package com.petplace.thatpetplace.auth.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("register")
    suspend fun register(
        @Body registrationPayload: RegistrationPayload
    ) : ApiResponse

    @POST("login")
    suspend fun login(
        @Body loginPayload: LoginPayload
    ) : LoginResponse
}