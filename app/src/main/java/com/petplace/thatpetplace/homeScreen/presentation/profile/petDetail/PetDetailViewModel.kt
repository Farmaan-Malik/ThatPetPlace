package com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PetDetailViewModel() : ViewModel() {

    private val _petsName =
        mutableStateOf("")

    val petsName: State<String> =  _petsName

    private val _species =
        mutableStateOf("")

    val species: State<String> = _species

    private val _breed =
        mutableStateOf("")

    val breed:State<String> = _breed

    private val _gender =
        mutableStateOf("Male")

    val gender:State<String> = _gender

    private val _age =
        mutableStateOf("")

    val age:State<String> = _age

    private val _neutered =
        mutableStateOf(false)

    val neutered:State<Boolean> = _neutered


    fun changeName(name:String){
        _petsName.value = name
    }
    fun changeBreed(breed:String){
        _breed.value = breed
    }
    fun changeSpecies(species:String){
        _species.value = species
    }
    fun changeGender(gender:String){
        _gender.value = gender
    }
    fun changeAge(age:String){
        _age.value = age
    }
    fun isNeutered(status: Boolean){
        _neutered.value = status
    }

}