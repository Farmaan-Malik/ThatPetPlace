package com.petplace.thatpetplace.homeScreen.profile.data.model

data class PetListResponse(
    val message: String,
    val pets: List<Pet>?
)