package com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote

import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.domain.ExploreRepository
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ExploreRepositoryImpl(private val api:ExploreApi):ExploreRepository {
    override fun getNearShops(locationData: LocationData): Flow<Resource<ShopResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.getNearShops(locationData)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }

    override fun getAllShops(): Flow<Resource<ShopResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.getAllShops()
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }
    override fun getFilteredShops(filter:String): Flow<Resource<ShopResponse>> {
        return flow {
            emit(value = Resource.Loading())
            val result = api.getFiltered(filter)
            emit(value = Resource.Success(data = result))
        }.catch {
            emit(value = Resource.Error(it.message.toString()))
        }
    }
}