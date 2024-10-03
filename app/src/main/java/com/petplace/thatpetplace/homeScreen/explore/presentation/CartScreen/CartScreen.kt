package com.petplace.thatpetplace.homeScreen.explore.presentation.CartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.homeScreen.explore.components.CartItem
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile

@Composable
fun CartScreen(navController: NavHostController, isProfile: () -> Unit) {
    LaunchedEffect(Unit) {
        isProfile()
    }
    DisposableEffect(Unit) {
        onDispose { isProfile() }
    }

    Scaffold(topBar = {
        TopBarProfile(title = "Cart", navController = navController)
    }

    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding(),
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(.9f)
            ) {
                items(20) {
                    CartItem {
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .shadow(8.dp,RoundedCornerShape(topEndPercent = 20, topStartPercent = 20))
                    .background(Color.White,RoundedCornerShape(20)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CustomButton(label = "Checkout") {
                }
            }

        }
    }
}