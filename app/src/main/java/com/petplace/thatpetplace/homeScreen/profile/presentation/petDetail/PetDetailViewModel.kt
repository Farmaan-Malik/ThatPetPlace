package com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail

import android.util.Log
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

class PetDetailViewModel(private val profileRepository: ProfileRepositoryImpl,private val globalStateDS: GlobalStateDS) : ViewModel() {

    val userId = globalStateDS.stateStatusFlow.map {
        it.userID
    }


init {
    getUserId()
}
    private var _imagePart: MultipartBody.Part? = null
    //function to save image state
    fun saveImage(part: MultipartBody.Part) {
        _imagePart = part
    }
    //function reset image state
    fun removeImage() {
        _imagePart = null
    }

    private val _petsName =
        mutableStateOf("")


    private val _species =
        mutableStateOf("")


    private val _breed =
        mutableStateOf("")


    private val _gender =
        mutableStateOf("Male")


    private val _age =
        mutableStateOf(0)


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

    fun changeAge(age: Int) {
        _age.value = age
    }

    fun isNeutered(status: Boolean) {
        _neutered.value = status
    }

    fun isVaccinated(status: Boolean) {
        _vaccinated.value = status
    }

    val string = mutableStateOf("")
    private fun getUserId(){
        viewModelScope.launch {
            userId.collectLatest {
                string.value = it
            }
        }

    }

    fun addPet() {
        viewModelScope.launch {
            profileRepository.addPet(
                addPetPayload = AddPetPayload(
                    age = _age.value,
                    breed = _breed.value,
                    dob = "12",
                    gender = _gender.value,
                    neutered = _neutered.value,
                    species = _species.value,
                    vaccinated = _vaccinated.value,
                    name = _petsName.value,
                    user_id =string.value
                )
            ).collectLatest {result->
                when (result) {
                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                    }

                    is Resource.Error -> {


                        Log.i("Error", result.message.toString())

                    }
                }
            }
        }

    }

}