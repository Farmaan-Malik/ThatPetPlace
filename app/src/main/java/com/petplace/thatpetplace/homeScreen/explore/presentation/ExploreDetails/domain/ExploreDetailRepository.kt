package com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.BookingResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.model.PetNameResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponseItem
import kotlinx.coroutines.flow.Flow

interface ExploreDetailRepository {

    fun getShopDetails(id:String): Flow<Resource<ShopResponseItem>>

    fun getPetListName(userId: String): Flow<Resource<PetNameResponse>>

    fun bookAppointment(appointmentPayload: NewAppointmentPayload): Flow<Resource<BookingResponse>>


}