package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponse
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.Flow

interface ExploreRepository {

    fun getNearShops(locationData: LocationData): Flow<Resource<ShopResponse>>
    fun getAllShops(): Flow<Resource<ShopResponse>>
    fun getFilteredShops(filter:String): Flow<Resource<ShopResponse>>

}