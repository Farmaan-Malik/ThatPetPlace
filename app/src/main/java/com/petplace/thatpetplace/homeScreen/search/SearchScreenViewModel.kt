package com.petplace.thatpetplace.homeScreen.search

import androidx.lifecycle.ViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import kotlinx.coroutines.flow.map

class SearchScreenViewModel( private val globalStateDS: GlobalStateDS): ViewModel() {
    val userName = globalStateDS.stateStatusFlow.map {
        it.firstName
    }
}