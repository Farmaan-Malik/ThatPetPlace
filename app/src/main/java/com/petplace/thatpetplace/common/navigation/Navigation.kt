package com.petplace.thatpetplace.common.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen
import com.petplace.thatpetplace.auth.presentation.signup.SignUp
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetails
import com.petplace.thatpetplace.homeScreen.HomeScreen
import com.petplace.thatpetplace.welcome.presentation.FirstScreen
import com.petplace.thatpetplace.welcome.presentation.SecondScreen
import com.petplace.thatpetplace.welcome.presentation.ThirdScreen
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation(
    viewModel: NaviagationViewModel = koinViewModel()
) {
    val navController = rememberNavController()



    Scaffold { paddingValues ->
        NavHost(navController = navController, startDestination = if (viewModel.currentUser ==null ) Routes.WelcomeRoutes.FIRST_SCREEN else Routes.AuthRoutes.LOGIN_SCREEN) {
            composable(Routes.AuthRoutes.LOGIN_SCREEN) {
                LoginScreen(navController)
            }
            composable(Routes.AuthRoutes.SIGNUP_SCREEN) {
                SignUp(navController)
            }
            composable(Routes.AuthRoutes.SIGNUP_DETAILS_SCREEN) {
                SignUpDetails(navController)
            }
            composable(Routes.WelcomeRoutes.FIRST_SCREEN) {
                FirstScreen(navController)
            }
            composable(Routes.WelcomeRoutes.SECOND_SCREEN) {
                SecondScreen(navController)
            }
            composable(Routes.WelcomeRoutes.THIRD_SCREEN) {
                ThirdScreen(navController)
            }
            composable(Routes.HomeScreenRoutes.HOME_SCREEN) {
                HomeScreen()
            }

        }

    }
}