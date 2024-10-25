package com.petplace.thatpetplace.auth.presentation.signupDetails

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
import kotlinx.coroutines.launch

class SignUpDetailsViewModel(
    private val authRepository: AuthRepositoryImpl,
    val globalStateDS: GlobalStateDS
) : ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
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
    fun updateUserId(userId: String) {
        viewModelScope.launch {
            globalStateDS.updateUserId(userId)
        }

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
                      _isLoading.value = true
                    }

                    is Resource.Success -> {

                        updateFirstName(first_name)
                        updateIsSignupComplete(true)
                        result.data?.let { updateUserId(it.id) }
                        Log.i("Success Signup", result.data.toString())
                        _isLoading.value = false


                    }

                    is Resource.Error -> {
                        _isError.value = true
                        _isLoading.value= false
                        Log.i("Error Signup", result.message.toString())
                    }
                }
            }
        }
    }
}