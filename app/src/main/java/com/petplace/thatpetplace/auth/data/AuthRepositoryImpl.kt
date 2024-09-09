package com.petplace.thatpetplace.auth.data

import com.petplace.thatpetplace.auth.domain.AuthRepository
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class AuthRepositoryImpl( private val api : AuthApi): AuthRepository {
    override fun loginUser(loginPayload: LoginPayload): Flow<Resource<LoginResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.login(loginPayload)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    override fun registration(registrationPayload: RegistrationPayload): Flow<Resource<ApiResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.register(registrationPayload)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }
}
