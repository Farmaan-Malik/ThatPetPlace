package com.petplace.thatpetplace.homeScreen.appointments

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppointmentScreenViewModel(): ViewModel() {

   val pastAppointment = mutableStateOf(listOf<String>("asd"))
    val upcomingAppointment = mutableStateOf(listOf<String>("hsg"))

}