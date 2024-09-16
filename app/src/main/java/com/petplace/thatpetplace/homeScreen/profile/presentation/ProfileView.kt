package com.petplace.thatpetplace.homeScreen.profile.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.homeScreen.profile.components.DisplayProfile
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileView(navController: NavHostController,paddingValues: PaddingValues, viewModel: ProfileViewViewModel = koinViewModel()) {
    DisplayProfile(viewModel = viewModel)
}