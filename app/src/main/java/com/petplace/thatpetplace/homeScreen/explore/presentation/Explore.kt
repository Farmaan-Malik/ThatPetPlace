package com.petplace.thatpetplace.homeScreen.explore.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.homeScreen.appointments.components.AppointmentToggle
import com.petplace.thatpetplace.homeScreen.explore.components.ExploreStoresCard
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun Explore(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: ExploreScreenViewModel = koinViewModel()
) {
    val isLoading by remember {
        viewModel.isLoading
    }
    val isError by remember {
        viewModel.isError
    }
    val isSuccess by remember {
        viewModel.isSuccess
    }
    val selectionType = remember {
        mutableStateOf("Stores")
    }
    val stores = remember {
        viewModel.stores.value
    }
    val nearest = remember {
        viewModel.nearbyShops.value
    }
    LaunchedEffect(Unit) {
        viewModel.getLocationData()
    }


    Scaffold(backgroundColor = Color(0xFFF8F7FB), topBar = {
        TopBarProfile(title = "Explore", navController = navController, elevation = 0.dp)
    }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            if (isLoading) {
                LoadingDialogBox()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .shadow(
                            8.dp, RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20)
                        )
                        .clip(RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20))
                        .background(Color.White), verticalArrangement = Arrangement.SpaceEvenly
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                            .height(40.dp)
                            .border(1.dp, Color(0xFFE4E3F3), RoundedCornerShape(50))
                            .background(Color.White)
                    ) {
                        AppointmentToggle(
                            title = "Stores",
                            isSelected = selectionType.value == "Stores",
                            width = .5f
                        ) {
                            selectionType.value = "Stores"/*TODO*/
                        }
                        AppointmentToggle(
                            title = "Nearest",
                            isSelected = selectionType.value == "Nearest",
                            width = 1f
                        ) {
                            selectionType.value = "Nearest"
                            viewModel.getNearbyShops()

                        }

                    }

                }


                if (selectionType.value == "Nearest" && stores.isNullOrEmpty() || selectionType.value == "Stores" && nearest.data.isNullOrEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock_filled),
                            contentDescription = "Icon",
                            tint = Color(0xFFBBC3CE),
                            modifier = Modifier.size(150.dp)
                        )
                        Text(
                            text = "No Shops here", color = Color(0xFFBBC3CE), fontSize = 20.sp
                        )
                    }
                } else LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = 10.dp, start = 8.dp, end = 8.dp
                        )
                ) {
                    if (selectionType.value == "Nearest") {
                        nearest.data?.let { arrayList ->
                            items(arrayList.toList()) { shop ->
                                ExploreStoresCard(
                                    name = shop.name,
                                    tagline = shop.tagline,
                                    distance = shop.Distance
                                ) { navController.navigate(Routes.HomeScreenRoutes.EXPLORE_DETAIL_SCREEN) }
                            }
                        }
                    } else {
                        items(8) {
                            ExploreStoresCard(
                                name = "",
                                tagline = "",
                                distance = 0.0
                            ) { navController.navigate(Routes.HomeScreenRoutes.EXPLORE_DETAIL_SCREEN) }
                        }
                    }

                }
            }

        }
    }
}