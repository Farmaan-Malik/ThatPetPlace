package com.petplace.thatpetplace.auth.data.remote

import com.petplace.thatpetplace.auth.data.model.ApiResponse
import com.petplace.thatpetplace.auth.data.model.LoginPayload
import com.petplace.thatpetplace.auth.data.model.LoginResponse
import com.petplace.thatpetplace.auth.data.model.RegistrationPayload
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("user/register")
    suspend fun register(
        @Body registrationPayload: RegistrationPayload
    ) : ApiResponse

    @POST("user/login")
    suspend fun login(
        @Body loginPayload: LoginPayload
    ) : LoginResponse
}