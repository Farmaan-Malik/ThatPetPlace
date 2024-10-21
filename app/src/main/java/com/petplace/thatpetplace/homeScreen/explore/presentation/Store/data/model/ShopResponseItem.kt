package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model

data class ShopResponseItem(
    val address: String,
    val description: String,
    val doctors: List<Doctor>,
    val id: String,
    val location: Location,
    val name: String,
    val phone_number: String,
    val products: List<Product>,
    val profile: String,
    val rating_count: Int,
    val ratings: Double,
    val services: List<Service>,
    val tagline: String,
    val type: String,
    val distance : Float
)