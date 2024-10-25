package com.petplace.thatpetplace.homeScreen.appointments

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.appointments.data.model.AppointmentStatusPayload
import com.petplace.thatpetplace.homeScreen.appointments.data.model.GetAllAppointmentResponse
import com.petplace.thatpetplace.homeScreen.appointments.data.remote.AppointmentRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AppointmentScreenViewModel(
    private val repository: AppointmentRepositoryImpl,
    val globalStateDS: GlobalStateDS
) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
    private var _appointments =
        MutableStateFlow<Resource<GetAllAppointmentResponse>>(Resource.Loading())
    val appointments: StateFlow<Resource<GetAllAppointmentResponse>> = _appointments
    val userID = globalStateDS.stateStatusFlow.map {
        it.userID
    }

    init {
        getAllAppointments()
    }

    fun getAllAppointments(
    ) {
        Log.e("popo", userID.toString())

        viewModelScope.launch {
            userID.collectLatest {
                it

                Log.i("HER", it)
                repository.getAllAppointments(it).collectLatest { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _isLoading.value = true
                        }

                        is Resource.Success -> {
                            Log.i("USEER", result.data.toString())
                            _appointments.value = result
                            _isLoading.value = false
                        }

                        is Resource.Error -> {
                            _isLoading.value = false
                            _isError.value = true
                            Log.i("SSSSSSS", result.message.toString())
                        }
                    }
                }
            }
        }
    }

    fun cancelAppointment(appoinmentStatusPayload: AppointmentStatusPayload) {
        Log.e("popo", userID.toString())

        viewModelScope.launch {
            repository.cancelAppointment(appoinmentStatusPayload).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.i("Success appointments", result.data.toString())
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        Log.i("Error appointments", result.message.toString())
                    }
                }
            }
        }.invokeOnCompletion { getAllAppointments() }
    }
}