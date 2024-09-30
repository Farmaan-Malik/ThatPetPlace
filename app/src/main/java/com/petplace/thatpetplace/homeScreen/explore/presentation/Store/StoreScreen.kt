package com.petplace.thatpetplace.homeScreen.explore.presentation.Store

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.explore.components.StoreCards
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile

@Composable
fun StoreScreen(paddingValues: PaddingValues, navController: NavHostController) {
    Scaffold(backgroundColor = Color(0xFFF8F7FB
    ), topBar = {
        TopBarProfile(title = "Store", navController = navController, elevation = 0.dp)
    }) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding() + it.calculateTopPadding())
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                verticalItemSpacing = 8.dp,

            ) {
                items(
                    12,
                    itemContent = { StoreCards(backgroundImage = R.drawable.product_placeholder) })

            }
        }

    }

}