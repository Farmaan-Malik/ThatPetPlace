package com.petplace.thatpetplace.homeScreen.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import kotlinx.coroutines.flow.map

class HomeScreenViewModel (globalStateDS: GlobalStateDS): ViewModel(){




    val isWelcomeCompleted = globalStateDS.stateStatusFlow.map {
        it.welcomeScreenCompleted
    }

    val isLoginCompleted = globalStateDS.stateStatusFlow.map {
        it.isLoggedIn
    }



}