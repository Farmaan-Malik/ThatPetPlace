package com.petplace.thatpetplace.homeScreen.explore.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
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
    filter: String,
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
    val stores = remember {
        viewModel.stores.value
    }
    val nearest = viewModel.nearbyShops.collectAsState()

    val allShops = viewModel.allStores.collectAsState()


    val context = LocalContext.current
    var latitude by remember { mutableStateOf(0.0) }
    var longitude by remember { mutableStateOf(0.0) }
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    // Permissions launcher to request location permissions
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) {
            getLocation(fusedLocationClient) { lat, lon ->
                Log.e("Longitude2", lon.toString())
                latitude = lat
                longitude = lon
            }
        } else {
            Log.d("Location", "Location permission denied")
        }
    }

    fun getNearestStores() {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        } else {
            // If permissions are granted, get the location
            getLocation(fusedLocationClient) { lat, lon ->
                Log.e("LAA", lat.toString() + "   " + lon.toString())
                viewModel.getNearbyShops(lat, lon)
            }
        }
    }
    LaunchedEffect(Unit) {
        Log.e("filter",filter)
        if (filter == "n") {
            Log.e("asas","plplpl",)
            getNearestStores()
        } else {
            viewModel.getFilteredShops(filter)
        }
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
                            title = if (filter == "n")"Nearest" else "Refresh",
                            isSelected = true,
                            width = 1f
                        ) {
                            if (filter == "n") {
                                getNearestStores()
                            } else {
                                viewModel.getFilteredShops(filter)
                            }

                        }

                    }

                }
                if (nearest.value.data.isNullOrEmpty()) {
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
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = 10.dp, start = 8.dp, end = 8.dp
                            )
                    ) {

                        Log.e("SSSSSS", "nearest seleceted")
                        if (!nearest.value.data.isNullOrEmpty()) {
                            items(nearest.value.data!!) { shop ->

                                ExploreStoresCard(
                                    name = shop.name,
                                    tagline = shop.tagline,
                                    distance = shop.distance
                                ) { navController.navigate(Routes.HomeScreenRoutes.EXPLORE_DETAIL_SCREEN + "/${shop.id}") }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getLocation(
    fusedLocationClient: FusedLocationProviderClient,
    onLocationRetrieved: (Double, Double) -> Unit
) {
    try {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    Log.e("Longitude", location.longitude.toString())
                    onLocationRetrieved(location.latitude, location.longitude)
                } else {
                    Log.d("Location", "Location is null")
                }
            }
            .addOnFailureListener {
                Log.e("Location", "Failed to get location: ${it.message}")
            }
    } catch (e: SecurityException) {
        Log.e("Location", "Location permission not granted")
    }
}