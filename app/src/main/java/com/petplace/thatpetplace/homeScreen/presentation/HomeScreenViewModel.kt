package com.petplace.thatpetplace.homeScreen.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl

class HomeScreenViewModel (private val authRepository: AuthRepositoryImpl): ViewModel(){

    private val _userName = mutableStateOf("")
    val userName : State<String> = _userName

}