package com.petplace.thatpetplace.homeScreen.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NavigationViewModel(val globalStateDS: GlobalStateDS):ViewModel() {
   val isWelcomeCompleted = globalStateDS.stateStatusFlow.map {
       it.welcomeScreenCompleted
   }
    val isLoginCompleted = globalStateDS.stateStatusFlow.map {
        it.isLoggedIn
    }

    fun updateIsWelcomeCompleted(completed:Boolean){
        viewModelScope.launch {
            globalStateDS.updateWelcomeStatus(completed)
        }

    }

}