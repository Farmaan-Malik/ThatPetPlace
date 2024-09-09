package com.petplace.thatpetplace.auth.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl
import com.petplace.thatpetplace.auth.data.LoginPayload
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepositoryImpl,
    private val globalStateDS: GlobalStateDS
) : ViewModel() {
    private var _loginState = MutableStateFlow<LoginState>(value = LoginState())
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()
    private var _login = MutableStateFlow<LoginPayload>(
        value = LoginPayload(
            email = "",
            password = "",
        )
    )

    fun updateIsLoginComplete(completed: Boolean) {
        viewModelScope.launch {
            globalStateDS.updateLoginStatus(completed)
        }

    }

    val loginPayloadState: StateFlow<LoginPayload> = _login.asStateFlow()
    fun loginUser(email: String, password: String) = viewModelScope.launch {
        _login.value = loginPayloadState.value.copy(
            email = email,
            password = password
        )
        Log.i("HER", "ijsnisjndsinsdcin")
        authRepository.loginUser(loginPayload = _login.value).collectLatest { result ->
            when (result) {
                is Resource.Loading -> {
                    _loginState.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    _loginState.update { it.copy(isSignInSuccessful = true) }
                    updateIsLoginComplete(true)
                    Log.i("USEER", result.data.toString())


                }

                is Resource.Error -> {
                    _loginState.update { it.copy(signInError = result.message) }

                    Log.i("SSSSSSS", result.message.toString())

                }
            }
        }
    }

}
//testformvalidation@email.com
//test123567