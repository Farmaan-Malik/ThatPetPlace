package com.petplace.thatpetplace.homeScreen.appointments.data.model

data class GetAllAppointmentResponseItem(
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
    val UserID: String
)