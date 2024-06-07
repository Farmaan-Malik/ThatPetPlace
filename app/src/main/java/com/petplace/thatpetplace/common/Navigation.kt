package com.petplace.thatpetplace.common

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()


    Scaffold { paddingValues ->
        NavHost(navController = navController, startDestination = "GameScreen") {
            composable("LoginScreen") {
                LoginScreen()
            }


        }

    }
}