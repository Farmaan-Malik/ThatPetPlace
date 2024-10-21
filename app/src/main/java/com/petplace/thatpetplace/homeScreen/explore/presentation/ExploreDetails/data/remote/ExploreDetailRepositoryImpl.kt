package com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.remote

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.BookingResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.model.PetNameResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.domain.ExploreDetailRepository
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ExploreDetailRepositoryImpl(private val api: ExploreDetailApi): ExploreDetailRepository {
    override fun getShopDetails(id:String): Flow<Resource<ShopResponseItem>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.getShopDetails(id)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }
    override fun getPetListName(userId: String): Flow<Resource<PetNameResponse>> {
        return flow {
            emit(Resource.Loading())
            val result = api.getPetList(userId)
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.localizedMessage))
        }
    }

    override fun bookAppointment(appointmentPayload: NewAppointmentPayload): Flow<Resource<BookingResponse>> {
            return flow {
                emit(value = Resource.Loading())
                val result = api.bookAppointment(appointmentPayload)
                emit(value = Resource.Success(data = result))
            }.catch {
                emit(value = Resource.Error(it.message.toString()))
            }
        }
    }

