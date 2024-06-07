package com.petplace.thatpetplace.common.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen
import com.petplace.thatpetplace.auth.presentation.signup.SignUp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()


    Scaffold { paddingValues ->
        NavHost(navController = navController, startDestination = Routes.AuthRoutes.LOGIN_SCREEN) {
            composable(Routes.AuthRoutes.LOGIN_SCREEN) {
                LoginScreen(navController)
            }

            composable(Routes.AuthRoutes.SIGNUP_SCREEN) {
                SignUp(navController)
            }

        }

    }
}