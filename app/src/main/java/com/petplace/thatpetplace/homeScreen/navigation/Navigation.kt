package com.petplace.thatpetplace.homeScreen.navigation


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.petplace.thatpetplace.auth.presentation.login.LoginScreen
import com.petplace.thatpetplace.auth.presentation.signup.SignUp
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetails
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.common.components.AnimationLoader
import com.petplace.thatpetplace.homeScreen.presentation.appointments.Appointments
import com.petplace.thatpetplace.homeScreen.presentation.explore.Explore
import com.petplace.thatpetplace.homeScreen.presentation.search.SearchScreen
import com.petplace.thatpetplace.welcome.presentation.FirstScreen
import com.petplace.thatpetplace.welcome.presentation.SecondScreen
import com.petplace.thatpetplace.welcome.presentation.ThirdScreen
import org.koin.androidx.compose.koinViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: NavigationViewModel = koinViewModel(),
    paddingValues: PaddingValues

) {

    val isWelcomeCompleted by viewModel.isWelcomeCompleted.collectAsState(initial = false)
    val isLoggedIn by viewModel.isLoginCompleted.collectAsState(initial = false)

    if (!viewModel.isLoading.value) {
        if (isWelcomeCompleted && isLoggedIn) {
            NavHost(
                navController = navController,
                startDestination = Routes.HomeScreenRoutes.HOME_SCREEN
            ) {

                composable(Routes.HomeScreenRoutes.SEARCH_SCREEN) {
                    SearchScreen(paddingValues)
                }
                composable(Routes.HomeScreenRoutes.APPOINTMENT_SCREEN) {
                    Appointments(paddingValues)
                }
                composable(Routes.HomeScreenRoutes.EXPLORE_SCREEN) {
                    Explore(paddingValues)
                }
                composable(Routes.HomeScreenRoutes.PROFILE_SCREEN) {

                    SignUp(navHostController = navController)
                }


            }
        } else if (!isLoggedIn && isWelcomeCompleted) {
            NavHost(
                navController = navController,
                startDestination = Routes.AuthRoutes.LOGIN_SCREEN
            ) {

                composable(Routes.AuthRoutes.LOGIN_SCREEN) {
                    LoginScreen(navHostController = navController)
                }
                composable(Routes.AuthRoutes.SIGNUP_SCREEN) {
                    SignUp(navHostController = navController)
                }
                composable(Routes.AuthRoutes.SIGNUP_DETAILS_SCREEN) {
                    SignUpDetails(navHostController = navController)
                }


            }
        } else {
            NavHost(
                navController = navController,
                startDestination = Routes.WelcomeRoutes.FIRST_SCREEN
            ) {
                composable(Routes.WelcomeRoutes.FIRST_SCREEN) {
                    FirstScreen(navHostController = navController)
                }
                composable(Routes.WelcomeRoutes.SECOND_SCREEN) {
                    SecondScreen(navHostController = navController)
                }
                composable(Routes.WelcomeRoutes.THIRD_SCREEN) {
                    ThirdScreen(navHostController = navController) {
                        viewModel.updateIsWelcomeCompleted(
                            completed = true
                        )
                    }
                }
            }
        }


    } else {
        Column(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFFDA8A5),
                        Color(0xFFFFCB9C),
                    )
                )
            ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimationLoader(modifier = Modifier.width(240.dp).height(240.dp))


        }

    }

}

