package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model

data class NearShopsResponseItem(
    val Distance: Double,
    val description: String,
    val id: String,
    val location: Location,
    val name: String,
    val ratings: Double,
    val services: Services,
    val tagline: String,
    val type: String
)