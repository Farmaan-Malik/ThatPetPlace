package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.domain

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.NearShopsResponse
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.Flow

interface ExploreRepository {

    fun getNearShops(locationData: LocationData): Flow<Resource<NearShopsResponse>>
    fun getAllShops(): Flow<Resource<NearShopsResponse>>
}