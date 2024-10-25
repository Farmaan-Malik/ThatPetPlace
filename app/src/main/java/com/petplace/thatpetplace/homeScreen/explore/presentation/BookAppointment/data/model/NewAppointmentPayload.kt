package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model

data class NewAppointmentPayload(
    val doctor_name: String,
    val appointment_date: String,
    val pet_name: String,
    val user_id: String,
    val clinic_id: String,
    val status: String,
    val doctor_qualification: String,
    val price: Float,
)