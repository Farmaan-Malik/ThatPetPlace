package com.petplace.thatpetplace.homeScreen.explore.presentation.Store

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.explore.components.StoreCards
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    navigate:()-> Unit={}
) {
    Scaffold(backgroundColor = Color(
        0xFFF8F7FB
    ), topBar = {
        TopBarProfile(title = "Store", navController = navController, elevation = 0.dp, onClick = {navigate()})
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding() + it.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                verticalItemSpacing = 6.dp,

                ) {
                items(
                    12,
                    itemContent = {
                        StoreCards(backgroundImage = R.drawable.product_placeholder) {
                            /*TODO*/
                        }
                    })

            }
        }

    }

}