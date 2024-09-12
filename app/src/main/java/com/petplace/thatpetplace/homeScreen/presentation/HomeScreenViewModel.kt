package com.petplace.thatpetplace.homeScreen.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeScreenViewModel (globalStateDS: GlobalStateDS): ViewModel(){

    init {
        delay()
    }
    val isLoading = mutableStateOf(true)


    val isWelcomeCompleted = globalStateDS.stateStatusFlow.map {
        it.welcomeScreenCompleted
    }

    val isLoginCompleted = globalStateDS.stateStatusFlow.map {
        it.isLoggedIn
    }
    fun delay(){
        viewModelScope.launch { kotlinx.coroutines.delay(6000) }.invokeOnCompletion {
            isLoading.value = false
        }
    }



}