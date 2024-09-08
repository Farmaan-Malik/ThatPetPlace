package com.petplace.thatpetplace.home.presentation.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.homeScreen.components.BottomNavBar
import com.petplace.thatpetplace.homeScreen.navigation.Navigation
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    val name = remember {
        mutableStateOf("Maria")
    }
    Scaffold(
        bottomBar = { BottomNavBar(navController = navHostController) })
    { paddingValues ->
        Navigation(navController = navHostController, paddingValues = paddingValues)

    }
}
