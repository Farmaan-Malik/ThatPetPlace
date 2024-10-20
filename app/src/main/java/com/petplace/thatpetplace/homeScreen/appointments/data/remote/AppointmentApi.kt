package com.petplace.thatpetplace.homeScreen.appointments.data.remote

import com.petplace.thatpetplace.homeScreen.appointments.data.model.GetAllAppointmentResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AppointmentApi {

    @GET("user/getAllAppointements")
    suspend fun getAllAppointments(
        @Query("userID") userID:String
    ):GetAllAppointmentResponse

}