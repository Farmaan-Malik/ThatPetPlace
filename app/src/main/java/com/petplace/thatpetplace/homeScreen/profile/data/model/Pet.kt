package com.petplace.thatpetplace.homeScreen.profile.data.model

data class Pet(
    val age: Int,
    val breed: String,
    val gender: String,
    val id: String,
    val name: String,
    val neutered: Boolean,
    val profile: Any,
    val species: String,
    val user_id: String,
    val vaccinated: Boolean
)