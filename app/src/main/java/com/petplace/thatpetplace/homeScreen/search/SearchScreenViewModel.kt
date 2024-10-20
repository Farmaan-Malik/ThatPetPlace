package com.petplace.thatpetplace.homeScreen.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SearchScreenViewModel( private val globalStateDS: GlobalStateDS): ViewModel() {
    val userName = globalStateDS.stateStatusFlow.map {
        it.firstName
    }
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    fun updateLocation(newLocationData: LocationData) {
        _location.value = newLocationData
        updateGSLocation(_location.value!!.latitude, _location.value!!.longitude)
    }
    fun updateGSLocation(latitude:Double,longitude:Double) {
        viewModelScope.launch {
            delay(2000)
            Log.e("newLocation", longitude.toString())
            globalStateDS.updateLatitude(latitude)
            globalStateDS.updateLongitude(longitude)
        }

    }
}