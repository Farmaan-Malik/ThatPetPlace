package com.petplace.thatpetplace.auth.domain

import com.petplace.thatpetplace.auth.data.model.ApiResponse
import com.petplace.thatpetplace.auth.data.model.LoginPayload
import com.petplace.thatpetplace.auth.data.model.LoginResponse
import com.petplace.thatpetplace.auth.data.model.RegistrationPayload
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginUser(loginPayload: LoginPayload): Flow<Resource<LoginResponse>>

   // fun googleSignIn():

    fun registration(registrationPayload: RegistrationPayload) : Flow<Resource<ApiResponse>>

}