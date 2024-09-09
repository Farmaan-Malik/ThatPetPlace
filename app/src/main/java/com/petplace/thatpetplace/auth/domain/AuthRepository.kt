package com.petplace.thatpetplace.auth.domain

import com.petplace.thatpetplace.auth.data.ApiResponse
import com.petplace.thatpetplace.auth.data.LoginPayload
import com.petplace.thatpetplace.auth.data.LoginResponse
import com.petplace.thatpetplace.auth.data.RegistrationPayload
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginUser(loginPayload: LoginPayload): Flow<Resource<LoginResponse>>

   // fun googleSignIn():

    fun registration(registrationPayload: RegistrationPayload) : Flow<Resource<ApiResponse>>

}