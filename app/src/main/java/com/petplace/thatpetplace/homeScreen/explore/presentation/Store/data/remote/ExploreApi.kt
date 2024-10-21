package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote

import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponse
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ExploreApi {

    @POST("user/petShopsNearUser")
    suspend fun getNearShops(
    @Body locationData: LocationData
    ):ShopResponse

    @GET("user/getPetShops")
    suspend fun getAllShops():ShopResponse

    @GET("user/getShopsFromService")
    suspend fun getFiltered(
        @Query("filter") filter:String
    ):ShopResponse

}