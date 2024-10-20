package com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.profile.data.model.AddPetPayload
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileRepositoryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class PetDetailViewModel(
    private val profileRepository: ProfileRepositoryImpl,
    private val globalStateDS: GlobalStateDS
) : ViewModel() {

    val userId = globalStateDS.stateStatusFlow.map {
        it.userID
    }
    private lateinit var petId: String
    private fun getUserId() {
        viewModelScope.launch {
            userId.collectLatest {
                string.value = it
            }
        }

    }

    init {
        getUserId()
    }

    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError

    private lateinit var _imagePart: MultipartBody.Part

    //function to save image state
    fun saveImage(part: MultipartBody.Part) {
        _imagePart = part
    }

    //function reset image state
//    fun removeImage() {
//        _imagePart = null
//    }

    private val _petsName =
        mutableStateOf("")


    private val _species =
        mutableStateOf("")


    private val _breed =
        mutableStateOf("")


    private val _gender =
        mutableStateOf("Male")


    private val _age =
        mutableStateOf("")


    private val _neutered =
        mutableStateOf(false)


    private val _vaccinated =
        mutableStateOf(false)


    fun changeName(name: String) {

        _petsName.value = name
    }

    fun changeBreed(breed: String) {
        _breed.value = breed
    }

    fun changeSpecies(species: String) {
        _species.value = species
    }

    fun changeGender(gender: String) {
        _gender.value = gender
    }

    fun changeAge(age: String) {
        _age.value = age
    }

    fun isNeutered(status: Boolean) {
        _neutered.value = status
    }

    fun isVaccinated(status: Boolean) {
        _vaccinated.value = status
    }

    val string = mutableStateOf("")


    fun addPet() =
        viewModelScope.launch {
            profileRepository.addPet(
                addPetPayload = AddPetPayload(
                    age = _age.value.toInt(),
                    breed = _breed.value,
                    gender = _gender.value,
                    neutered = _neutered.value,
                    species = _species.value,
                    vaccinated = _vaccinated.value,
                    name = _petsName.value,
                    user_id = string.value
                )
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                        petId = result.data!!.id
                        _isSuccess.value = true
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        _isSuccess.value = false
                        Log.i("Error", result.message.toString())

                    }
                }
            }
        }

    fun uploadPhoto() =
        viewModelScope.launch {
            Log.e("petId", petId)
            profileRepository.uploadPetProfile(
                petID = petId,
                photo = _imagePart
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())

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