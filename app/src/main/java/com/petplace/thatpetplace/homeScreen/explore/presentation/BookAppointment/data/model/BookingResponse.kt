package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model

data class BookingResponse(
    val AppointmentDate: String,
    val CLinicID: String,
    val ClinicAddress: String,
    val ClinicName: String,
    val Confirmation: String,
    val Confirmed: Boolean,
    val DoctorName: String,
    val DoctorQualification: String,
    val ID: String,
    val PetName: String,
    val Price: Int,
    val Status: String,
    val UserID: String,
    val error: String
)