package com.petplace.thatpetplace.auth.presentation.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.auth.data.model.LoginPayload
import com.petplace.thatpetplace.auth.data.remote.AuthRepositoryImpl
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepositoryImpl,
    private val globalStateDS: GlobalStateDS
) : ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
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
    fun updateUserId(userId: String) {
        viewModelScope.launch {
            globalStateDS.updateUserId(userId)
        }

    }
    fun updateFirstName(firstName: String) {
        viewModelScope.launch {
            globalStateDS.updateFirstName(firstName)
        }

    }

    val loginPayloadState: StateFlow<LoginPayload> = _login.asStateFlow()
    fun loginUser(email: String, password: String) = viewModelScope.launch {
        _login.value = loginPayloadState.value.copy(
            email = email,
            password = password
        )
        Log.i("HER", isLoading.value.toString())
        authRepository.loginUser(loginPayload = _login.value).collectLatest { result ->
            when (result) {
                is Resource.Loading -> {
                    _isLoading.value = true
                    Log.i("loading", isLoading.value.toString())

                }

                is Resource.Success -> {
                    _isLoading.value = false
                    result.data?.let { updateUserId(it.userId) }
                    result.data?.let { updateFirstName(it.first_name) }

                    updateIsLoginComplete(true)
                    Log.i("complete", isLoading.value.toString())

                    Log.i("USEER", result.data.toString())


                }

                is Resource.Error -> {
                    _isLoading.value = false
                    _isError.value= true
                    Log.i("loadf", isLoading.value.toString())

                    Log.i("SSSSSSS", result.message.toString())

                }
            }
        }
    }
    fun updateError(){
        _isError.value = !_isError.value
    }

}
//testformvalidation@email.com
//test123567