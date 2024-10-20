package com.petplace.thatpetplace.homeScreen.explore.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Resource
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.NearShopsResponse
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote.ExploreRepositoryImpl
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ExploreScreenViewModel(
    private val repository: ExploreRepositoryImpl,
    private val globalStateDS: GlobalStateDS
) : ViewModel() {

    // Initialize FusedLocationProviderClient
//    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(MainActivity().baseContext)


    // Get the last known location
//    getLastLocation()


//    @SuppressLint("MissingPermission")
//    private fun getLastLocation() {
//        fusedLocationClient.lastLocation
//            .addOnSuccessListener { location ->
//                if (location != null) {
//                    val latitude = location.latitude
//                    val longitude = location.longitude
//
//                    // Log or use the latitude and longitude values
//                    Log.d("Location", "Latitude: $latitude, Longitude: $longitude")
//                } else {
//                    Log.d("Location", "Location not available")
//                }
//            }
//            .addOnFailureListener { e ->
//                Log.e("Location", "Failed to get location: ${e.message}")
//            }
//    }

//init {
//    getLastLocation()
//}

    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _isError = mutableStateOf(false)
    val isError: State<Boolean> = _isError
    val stores = mutableStateOf(listOf<String>("asd"))
    val clinics = mutableStateOf(listOf<String>("hsg"))
    private val _nearbyShops = MutableStateFlow<Resource<NearShopsResponse>>(Resource.Loading())
    val nearbyShops: StateFlow<Resource<NearShopsResponse>> = _nearbyShops

    val latitude = globalStateDS.stateStatusFlow.map {
        it.latitude
    }
    val longitude = globalStateDS.stateStatusFlow.map {
        it.longitude
    }
    var newLat: Double = 0.0
    var newLong: Double = 0.0


    fun getLocationData() {
        viewModelScope.launch {
            latitude.collectLatest {
                newLat = it
            }
            longitude.collectLatest {
                newLong = it
            }
        }

    }

    fun getNearbyShops() {
        Log.e("Location", newLat.toString() +" "+ newLong.toString())
        viewModelScope.launch {
            repository.getNearShops(
                LocationData(newLat, newLong)
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

}