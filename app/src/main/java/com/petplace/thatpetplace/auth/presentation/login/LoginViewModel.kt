package com.petplace.thatpetplace.auth.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel (private val authRepository: AuthRepositoryImpl):ViewModel(){
    private var _loginState = MutableStateFlow<LoginState>(value = LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun loginUser(email:String,password:String) = viewModelScope.launch {
        Log.i("HER","ijsnisjndsinsdcin")
        authRepository.loginUser(email = email, password = password).collectLatest { result ->
            when(result) {
                is Resource.Loading -> {
                    _loginState.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    _loginState.update { it.copy(isSignInSuccessful = true) }

                    Log.i("USEER",result.data.toString())


                }

                is Resource.Error -> {
                    _loginState.update { it.copy(signInError = result.message) }

                    Log.i("SSSSSSS",result.message.toString())

                }
            }
        }
    }

}
//testformvalidation@email.com
//test123567