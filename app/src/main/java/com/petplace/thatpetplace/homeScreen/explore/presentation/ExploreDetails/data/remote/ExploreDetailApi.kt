package com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.remote

import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.BookingResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.data.model.PetNameResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ExploreDetailApi {

    @GET("user/getShopDetails")
    suspend fun getShopDetails(
        @Query("storeID") id:String
    ): ShopResponseItem

    @GET("pet/getAllPets")
    suspend fun getPetList (
        @Query("userID") userID:String
    ) : PetNameResponse

    @POST("user/bookAppointment")
    suspend fun bookAppointment(
        @Body appointmentPayload: NewAppointmentPayload
    ) : BookingResponse
}