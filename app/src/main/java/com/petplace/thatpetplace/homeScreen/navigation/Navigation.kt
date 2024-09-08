package com.petplace.thatpetplace.homeScreen.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.presentation.appointments.Appointments
import com.petplace.thatpetplace.homeScreen.presentation.explore.Explore
import com.petplace.thatpetplace.homeScreen.presentation.profile.Profile
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailScreen
import com.petplace.thatpetplace.homeScreen.presentation.search.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues
//viewModel: NaviagationViewModel = koinViewModel()
) {

        NavHost(navController = navController, startDestination = Routes.HomeScreenRoutes.SEARCH_SCREEN) {

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
                Profile(navController,paddingValues)
            }
            composable(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) {
                PetDetailScreen(navController, paddingValues = paddingValues)
            }


        }

    }
