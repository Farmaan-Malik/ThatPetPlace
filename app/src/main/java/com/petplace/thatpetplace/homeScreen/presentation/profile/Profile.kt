package com.petplace.thatpetplace.homeScreen.presentation.profile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailScreen

@Composable
fun Profile(navController: NavHostController,paddingValues: PaddingValues) {
    Scaffold { it
        PetDetailScreen(navController = navController, paddingValues = paddingValues)
    }
}