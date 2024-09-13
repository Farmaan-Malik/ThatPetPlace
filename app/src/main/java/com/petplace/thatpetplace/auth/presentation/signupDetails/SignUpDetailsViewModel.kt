package com.petplace.thatpetplace.auth.presentation.signupDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.auth.data.model.RegistrationPayload
import com.petplace.thatpetplace.auth.data.remote.AuthRepositoryImpl
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpDetailsViewModel(
    private val authRepository: AuthRepositoryImpl,
    val globalStateDS: GlobalStateDS
) : ViewModel() {
    private var _signupState = MutableStateFlow<RegistrationState>(value = RegistrationState())
    val signupState: StateFlow<RegistrationState> = _signupState.asStateFlow()
    private var _registration = MutableStateFlow<RegistrationPayload>(
        value = RegistrationPayload(
            email = "",
            first_name = "",
            last_name = "",
            password = "",
            phone_number = ""
        )
    )
    val registrationState: StateFlow<RegistrationPayload> = _registration.asStateFlow()
    val isSignupCompleted = globalStateDS.stateStatusFlow.map {
        it.isLoggedIn
    }

    fun updateIsSignupComplete(completed:Boolean){
        viewModelScope.launch {
            globalStateDS.updateLoginStatus(completed)
        }

    }
    fun updateFirstName(first_name: String){
        viewModelScope.launch {
            globalStateDS.updateFirstName(first_name)
        }

    }

    fun registration(
        email: String,
        first_name: String,
        last_name: String,
        password: String,
        phone_number: String
    ) {
        viewModelScope.launch {
            _registration.value = registrationState.value.copy(
                email = email,
                phone_number = phone_number,
                first_name = first_name,
                last_name = last_name,
                password = password
            )
            Log.i("HER", "ijsnisjndsinsdcin")
            authRepository.registration(_registration.value).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _signupState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _signupState.update { it.copy(isSignInSuccessful = true) }
                        updateIsSignupComplete(true)
                        updateFirstName(first_name)
                        Log.i("USEER", result.data.toString())


                    }

                    is Resource.Error -> {
                        _signupState.update { it.copy(signInError = result.message) }

                        Log.i("SSSSSSS", result.message.toString())

                    }
                }
            }
        }
    }
}