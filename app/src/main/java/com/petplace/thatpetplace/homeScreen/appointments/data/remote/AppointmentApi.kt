package com.petplace.thatpetplace.homeScreen.appointments.data.remote

import com.petplace.thatpetplace.homeScreen.appointments.data.model.AppointmentStatusPayload
import com.petplace.thatpetplace.homeScreen.appointments.data.model.AppointmentStatusResponse
import com.petplace.thatpetplace.homeScreen.appointments.data.model.GetAllAppointmentResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppointmentApi {

    @GET("user/getAllAppointements")
    suspend fun getAllAppointments(
        @Query("userID") userID:String
    ):GetAllAppointmentResponse
    @POST("appointment/status")
    suspend fun cancelAppointment(
        @Body appointmentStatus: AppointmentStatusPayload
    ):AppointmentStatusResponse

}