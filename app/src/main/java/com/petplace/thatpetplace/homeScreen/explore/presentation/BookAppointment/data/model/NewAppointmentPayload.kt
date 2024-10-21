package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model

data class NewAppointmentPayload(
    val DoctorName: String,
    val AppointmentDate: String,
    val PetName: String,
    val UserID: String,
    val CLinicID: String,
    val Status: String,
    val DoctorQualification: String,
    val Price: Int,
)