package com.petplace.thatpetplace.homeScreen.explore.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote.ExploreRepositoryImpl
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ExploreScreenViewModel(
    private val repository: ExploreRepositoryImpl,
) : ViewModel() {

    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
    val stores = mutableStateOf(listOf<String>("asd"))
    val clinics = mutableStateOf(listOf<String>("hsg"))
    private val _nearbyShops = MutableStateFlow<Resource<ShopResponse>>(Resource.Loading())
    val nearbyShops: StateFlow<Resource<ShopResponse>> = _nearbyShops
    private val _allStores = MutableStateFlow<Resource<ShopResponse>>(Resource.Loading())
    val allStores: StateFlow<Resource<ShopResponse>> = _allStores


    fun getNearbyShops(lat: Double, long: Double) {
        Log.e("Loddddddcation", lat.toString() + " " + long.toString())
        viewModelScope.launch {
            repository.getNearShops(
                LocationData(long, lat)
            ).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success", result.data.toString())
                        _nearbyShops.value = result
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        Log.i("Error", result.message.toString())

                    }
                }
            }
        }

    }

    fun getFilteredShops(filter: String) {

        viewModelScope.launch {
            repository.getFilteredShops(filter).collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        Log.e("Success ALl ", result.data.toString())
                        _nearbyShops.value = result
                        _isLoading.value = false
                    }

                    is Resource.Error -> {
                        _isLoading.value = false
                        _isError.value = true
                        Log.i("Error", result.message.toString())

                    }
                }
            }
        }
    }
}