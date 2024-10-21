package com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.homeScreen.explore.components.ExploreClinicsCard
import com.petplace.thatpetplace.homeScreen.explore.components.ExploreDetailCard
import com.petplace.thatpetplace.homeScreen.explore.components.TopBarExplore
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.BookAppointments
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.StoreScreen
import com.petplace.thatpetplace.homeScreen.profile.components.ColorToggleButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExploreDetailScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    id: String,
    viewModel: ExploreDetailScreenViewModel = koinViewModel(),
    isProfile: () -> Unit
) {
    Log.e("idsw", id)
    val currentPage = remember {
        mutableStateOf("Clinic")
    }
    val selectedDoctor = remember {
        mutableStateOf("")
    }
    val qualification = remember {
        mutableStateOf("")
    }
    val fees = remember {
        mutableStateOf(0)
    }
    val isLoading by remember {
        viewModel.isLoading
    }
    val Fab = remember {
        mutableStateOf(true)
    }
    val shopDetails = viewModel.shopDetails.collectAsState()

    LaunchedEffect(Unit) {
        isProfile()
        viewModel.getShopDetails(id)
    }
    DisposableEffect(Unit) {
        onDispose { isProfile() }
    }
    if (currentPage.value == "Clinic") {
        Scaffold(topBar = {
            TopBarExplore(navController = navController)
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = paddingValues.calculateBottomPadding() + it.calculateBottomPadding())
            ) {
                if (isLoading) {
                    LoadingDialogBox()
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(painter = painterResource(id = R.drawable.pet_profile),
                            contentDescription = "Profile photo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.drawWithCache {
                                val gradient = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF7993D7),
                                        Color.White,
                                        Color.Transparent,
                                        Color.Transparent
                                    ), startY = size.height / 5, endY = size.height
                                )
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(gradient, blendMode = BlendMode.Multiply)
                                }
                            })
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 25.dp)
                    ) {
                        shopDetails.value.data?.let { it1 ->
                            ExploreDetailCard(
                                offsetX = 0.dp, offsetY = (-70).dp, details = it1
                            )
                        }
                        Text(
                            text = "\"" + shopDetails.value.data?.tagline + "\"",
                            fontSize = 20.sp,
                            color = Color(0xFFBBC3CE),
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.offset(x = 0.dp, y = (-30).dp)
                        )
                        Text(
                            text = "About us:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Box(
                            modifier = Modifier
                                .shadow(8.dp, RoundedCornerShape(20.dp))
                                .background(
                                    Color.White, shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            shopDetails.value.data?.let { it1 ->
                                Text(
                                    text = it1.description, modifier = Modifier.padding(
                                        top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp
                                    ), fontSize = 14.sp
                                )
                            }
                        }


                        Text(
                            text = "Available doctors: ",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )

                    }
                    if (!shopDetails.value.data?.doctors.isNullOrEmpty()) {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth()

                        ) {
                            shopDetails.value.data?.let { it1 ->
                                items(it1.doctors) { doctor ->
                                    ExploreClinicsCard(doctor = doctor,
                                        clinicName = shopDetails.value.data!!.name,
                                        distance = shopDetails.value.data!!.distance.toString(),
                                        selected = selectedDoctor.value == doctor.name,
                                        onClick = {
                                            if (selectedDoctor.value == doctor.name) {
                                                Fab.value = true
                                                selectedDoctor.value = ""
                                            } else {
                                                Fab.value = false
                                                selectedDoctor.value = doctor.name
                                                fees.value = doctor.fees
                                            }
                                        })
                                }
                            }
                        }
                    } else {
                        Text(
                            text = "No Doctors Available",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0x95D1CCE8),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 16.dp)
                            .shadow(
                                16.dp, RoundedCornerShape(topEndPercent = 30, topStartPercent = 30)
                            )
                            .clip(
                                RoundedCornerShape(topEndPercent = 30, topStartPercent = 30)
                            )
                            .background(Color.White),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (Fab.value) {
                                ListItem(headlineContent = { Text(text = "Shop with us Today!") },
                                    overlineContent = { Text(text = "We sell Products too!") },
                                    leadingContent = {
                                        Icon(
                                            imageVector = Icons.Rounded.ShoppingCart,
                                            contentDescription = "Shop"
                                        )
                                    },
                                    trailingContent = {
                                        ColorToggleButton(
                                            onClick = {
                                                currentPage.value = "Store"
                                            }, label = "Store", selected = true
                                        )
                                    })
                            } else {
                                ListItem(headlineContent = { Text(text = "Name: " + selectedDoctor.value) },
                                    supportingContent = {
                                        Text(
                                            text = "Fees: " + "$ " + fees.value
                                        )
                                    },
                                    leadingContent = {
                                        Icon(
                                            imageVector = Icons.Rounded.Person,
                                            contentDescription = "Doctor"
                                        )
                                    },
                                    trailingContent = {
                                        ColorToggleButton(
                                            onClick = {
                                                currentPage.value = "Appointments"

                                            }, label = "Book", selected = true
                                        )
                                    })
                            }
                        }
                    }
                }
            }
        }
    } else if (currentPage.value == "Store") {
        StoreScreen(paddingValues = paddingValues,
            navController = navController,
            navigate = { currentPage.value = "Clinic" })
    } else shopDetails.value.data?.let {
        BookAppointments(
            doctorName = selectedDoctor.value,
            qualification = qualification.value,
            fees = fees.value.toFloat(),
            clinicID = it.id,
            paddingValues = paddingValues
        ) {
            currentPage.value = "Clinic"
        }
    }
}