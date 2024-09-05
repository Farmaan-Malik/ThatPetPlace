package com.petplace.thatpetplace.homeScreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.presentation.appointments.Appointments
import com.petplace.thatpetplace.homeScreen.presentation.explore.Explore
import com.petplace.thatpetplace.homeScreen.presentation.profile.Profile
import com.petplace.thatpetplace.homeScreen.presentation.search.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController,
//viewModel: NaviagationViewModel = koinViewModel()
) {

        NavHost(navController = navController, startDestination = Routes.HomeScreenRoutes.PROFILE_SCREEN) {

            composable(Routes.HomeScreenRoutes.SEARCH_SCREEN) {
                SearchScreen()
            }
            composable(Routes.HomeScreenRoutes.APPOINTMENT_SCREEN) {
                Appointments()
            }
            composable(Routes.HomeScreenRoutes.EXPLORE_SCREEN) {
                Explore()
            }
            composable(Routes.HomeScreenRoutes.PROFILE_SCREEN) {
                Profile(navController)
            }


        }

    }
