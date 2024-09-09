package com.petplace.thatpetplace.auth.presentation.signupDetails

data class RegistrationState(
val isSignInSuccessful: Boolean = false,
val signInError: String? = null,
val isLoading:Boolean = false
)
