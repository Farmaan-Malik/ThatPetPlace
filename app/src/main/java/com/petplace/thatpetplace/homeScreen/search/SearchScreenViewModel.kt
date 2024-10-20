package com.petplace.thatpetplace.homeScreen.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.homeScreen.search.location.LocationData
import kotlinx.coroutines.flow.map

class SearchScreenViewModel( private val globalStateDS: GlobalStateDS): ViewModel() {
    val userName = globalStateDS.stateStatusFlow.map {
        it.firstName
    }
    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    fun updateLocation(newLocationData: LocationData) {
        _location.value = newLocationData
    }

}