package com.petplace.thatpetplace.homeScreen.profile.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.profile.components.DisplayPet
import com.petplace.thatpetplace.homeScreen.profile.components.DisplayProfile
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileView(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ProfileViewViewModel = koinViewModel()
) {
    Scaffold(backgroundColor = Color(0xFFF8F7FB), topBar = {
        TopBarProfile(
            enabled = false,
            title = "Profile",
            navController = navController,
            elevation = 0.dp
        )
    }) { it ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            DisplayProfile(viewModel = viewModel, navController)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 64.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(3) {
                    DisplayPet { navController.navigate(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) }
                }
            }
        }
    }
}