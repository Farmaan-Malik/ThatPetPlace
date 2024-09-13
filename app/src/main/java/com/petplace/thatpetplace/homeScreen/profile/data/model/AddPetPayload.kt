package com.petplace.thatpetplace.homeScreen.profile.data.model

data class AddPetPayload(
    val age: Int,
    val breed: String,
    val dob: String,
    val gender: String,
    val neutered: Boolean,
    val species: String,
    val vaccinated: Boolean,
    val name: String,
    val user_id: String
)