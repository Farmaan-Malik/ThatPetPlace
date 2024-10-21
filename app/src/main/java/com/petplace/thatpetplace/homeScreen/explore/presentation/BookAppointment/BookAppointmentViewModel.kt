package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.model.PetName
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.remote.ExploreDetailRepositoryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BookAppointmentViewModel(
    private val repository: ExploreDetailRepositoryImpl,
    val globalStateDS: GlobalStateDS
): ViewModel() {
    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
    private var _listOfPetName =
        mutableStateOf(listOf(PetName("")))
    val listOfPetsName: State<List<PetName>> = _listOfPetName
    val userId = globalStateDS.stateStatusFlow.map {
        it.userID
    }
    val string = mutableStateOf("")

    fun getUserId() {
        viewModelScope.launch {
            userId.collectLatest {
                string.value = it
                getPetList()
            }
        }
    }
    init {
        getUserId()
    }
    fun getPetList() {
        viewModelScope.launch {
           repository.getPetListName(
                userId = string.value
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                        _listOfPetName.value = result.data!!.pets
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        Log.i("Error", result.message.toString())

                    }
                }
            }
        }
    }
    fun bookAppointment(appointmentPayload: NewAppointmentPayload) = viewModelScope.launch {
        Log.e("payload", appointmentPayload.toString())
        Log.i("HER", isLoading.value.toString())
        repository.bookAppointment(appointmentPayload).collectLatest { result ->
            when (result) {
                is Resource.Loading -> {
                    _isLoading.value = true
                    Log.i("loading", isLoading.value.toString())

                }

                is Resource.Success -> {
                    _isLoading.value = false

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
}