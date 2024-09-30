package com.petplace.thatpetplace.homeScreen.profile.presentation.profileDetail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import okhttp3.MultipartBody

class ProfileScreenViewModel(): ViewModel() {


    private val _firstName =
        mutableStateOf("")
    private val _lastName =
        mutableStateOf("")
    private val _gender =
        mutableStateOf("")
    private val _email =
        mutableStateOf("")
    private val _phoneNumber =
        mutableStateOf("")
    private var _imagePart: MultipartBody.Part? = null
    //function to save image state
    fun saveImage(part: MultipartBody.Part) {
        _imagePart = part
    }
    //function reset image state
    fun removeImage() {
        _imagePart = null
    }

    fun changeFirstName(firstName: String) {
        _firstName.value = firstName
    }
    fun changeLastName(lastName: String) {
        _lastName.value = lastName
    }
    fun changeGender(gender: String) {
        _gender.value = gender
    }
    fun changeEmail(email: String) {
        _email.value = email
    }
    fun changePhoneNumber(phoneNumber: String) {
        _phoneNumber.value = phoneNumber
    }

}