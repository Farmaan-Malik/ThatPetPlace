package com.petplace.thatpetplace.homeScreen.appointments.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.appointments.data.model.GetAllAppointmentResponse
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    fun getAllAppointments(userID: String): Flow<Resource<GetAllAppointmentResponse>>

}