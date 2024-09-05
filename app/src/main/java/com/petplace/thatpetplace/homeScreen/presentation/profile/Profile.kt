package com.petplace.thatpetplace.homeScreen.presentation.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailScreen

@Composable
fun Profile(navController: NavHostController) {
    PetDetailScreen(navController = (navController))
}