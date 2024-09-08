package com.petplace.thatpetplace.home.presentation.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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

    val welcomeCompleted by viewModel.isWelcomeCompleted.collectAsState(initial = false)
    val isLoggedIn by viewModel.isLoginCompleted.collectAsState(initial = false)

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { if (welcomeCompleted && isLoggedIn){ BottomNavBar(navController = navHostController)}}

    )
    {   paddingValues ->

        Navigation(navController = navHostController)

    }
}
