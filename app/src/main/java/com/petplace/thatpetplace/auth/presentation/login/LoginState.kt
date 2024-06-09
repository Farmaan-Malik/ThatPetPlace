package com.petplace.thatpetplace.auth.presentation.login

data class LoginState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val isLoading:Boolean = false
)