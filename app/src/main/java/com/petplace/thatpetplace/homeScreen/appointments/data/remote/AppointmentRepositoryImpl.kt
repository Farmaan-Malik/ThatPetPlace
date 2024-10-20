package com.petplace.thatpetplace.homeScreen.appointments.data.remote

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.appointments.data.model.GetAllAppointmentResponse
import com.petplace.thatpetplace.homeScreen.appointments.domain.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class AppointmentRepositoryImpl(private var api: AppointmentApi ): AppointmentRepository {
    override fun getAllAppointments(userID: String): Flow<Resource<GetAllAppointmentResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.getAllAppointments(userID)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }
}