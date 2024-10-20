package com.petplace.thatpetplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.petplace.thatpetplace.home.presentation.homeScreen.HomeScreen
import com.petplace.thatpetplace.ui.theme.ThatPetPlaceTheme

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            ThatPetPlaceTheme {
                val navController = rememberNavController()
                HomeScreen(navHostController = navController)
            }
        }
    }
}