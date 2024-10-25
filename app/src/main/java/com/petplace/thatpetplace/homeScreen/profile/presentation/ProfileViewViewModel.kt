package com.petplace.thatpetplace.homeScreen.profile.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.profile.data.model.Pet
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileRepositoryImpl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ProfileViewViewModel(
    private val profileRepository: ProfileRepositoryImpl,
    private val globalStateDS: GlobalStateDS
) : ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
    private var _listOfPets: MutableState<List<Pet>?> =
        mutableStateOf(
            listOf(
                Pet(
                    0,
                    "",
                    "",
                    "",
                    "",
                    neutered = false,
                    "",
                    "",
                    "",
                    vaccinated = false
                )
            )
        )
    val listOfPets: State<List<Pet>?> = _listOfPets
    val userId = globalStateDS.stateStatusFlow.map {
        it.userID
    }
    val string = mutableStateOf("")

    private fun getUserId() {
        viewModelScope.launch {
            userId.collectLatest {
                string.value = it
                getPetList()
            }
        }
    }

    fun updateError() {
        _isError.value = false
    }

    init {
        getUserId()
    }

    fun getPetList() {
        Log.e("userIdProfile", string.value)
        viewModelScope.launch {
            profileRepository.getPetList(
                userId = string.value
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                        _listOfPets.value = result.data?.pets
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

    fun deletePet(petID: String) {
        viewModelScope.launch {
            profileRepository.deletePet(
                petID
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }
                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                        delay(500)
                        _isLoading.value = false
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        Log.i("Error", result.message.toString())
                    }
                }
            }
        }.invokeOnCompletion { getPetList() }
    }
}