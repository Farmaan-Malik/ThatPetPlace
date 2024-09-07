package com.petplace.thatpetplace.auth.domain

import android.content.Context
import com.google.firebase.auth.AuthResult
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>

   // fun googleSignIn():

}