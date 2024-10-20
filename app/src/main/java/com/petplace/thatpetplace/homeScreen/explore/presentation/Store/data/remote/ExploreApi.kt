package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote

import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.NearShopsResponse
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import retrofit2.http.Body
import retrofit2.http.POST

interface ExploreApi {

    @POST("user/petShopsNearUser")
    suspend fun getNearShops(
    @Body locationData: LocationData
    ):NearShopsResponse
}