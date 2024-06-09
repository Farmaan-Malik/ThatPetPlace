package com.petplace.thatpetplace.common.navigation

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class NaviagationViewModel(private val firebaseAuth: FirebaseAuth):ViewModel() {
    val currentUser = firebaseAuth.currentUser
}