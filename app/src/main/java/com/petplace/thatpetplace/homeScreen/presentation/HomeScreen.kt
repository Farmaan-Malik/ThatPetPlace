package com.petplace.thatpetplace.home.presentation.homeScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.common.components.AnimationLoader
import com.petplace.thatpetplace.homeScreen.components.BottomNavBar
import com.petplace.thatpetplace.homeScreen.navigation.Navigation
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel


@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    val name = remember {
        mutableStateOf("Maria")
    }
var isProfile by remember {
    mutableStateOf(false
    )
}
    val welcomeCompleted by viewModel.isWelcomeCompleted.collectAsState(initial = false)
    val isLoggedIn by viewModel.isLoginCompleted.collectAsState(initial = false)

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (welcomeCompleted && isLoggedIn && !viewModel.isLoading.value) {
                if (!isProfile) {
                    BottomNavBar(navController = navHostController)
                }
            }
        }
    )
    { paddingValues ->

        if (!viewModel.isLoading.value) {
            Navigation(navController = navHostController, paddingValues = paddingValues, isProfile = {isProfile = !isProfile})
        }
        else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
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
            AnimationLoader(modifier = Modifier
                .width(240.dp)
                .height(240.dp))


        }

    }

    }
}
