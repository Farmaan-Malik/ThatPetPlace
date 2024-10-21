package com.petplace.thatpetplace.homeScreen.search

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.MainActivity
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.components.HomeScreenTile
import com.petplace.thatpetplace.homeScreen.search.components.TopBarSearch
import com.petplace.thatpetplace.homeScreen.search.location.LocationUtils
import com.petplace.thatpetplace.ui.theme.encode
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    navController: NavHostController,
    viewModel: SearchScreenViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            ) {
                // I HAVE ACCESS to location
                locationUtils.requestLocationUpdates(viewModel = viewModel)
            } else {
                val rationaleRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
                if (rationaleRequired) {
                    Toast.makeText(
                        context,
                        "Location Permission is required",
                        Toast.LENGTH_LONG
                    )
                        .show()
                } else {
                    Toast.makeText(
                        context,
                        "Location Permission is required. Please enable it in the Android Settings",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        })
    fun checkLocation(){
        if (locationUtils.hasLocationPermission(context)) {
            // Permission already granted update the location
            locationUtils.requestLocationUpdates(viewModel)
        } else {
            // Request location permission
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    LaunchedEffect(Unit) {
       checkLocation()
    }

    val userName by
    viewModel.userName.collectAsState("")
    val location = viewModel.location.value

    val address = location?.let {
        locationUtils.reverseGeocodeLocation(location)
    }

    fun navigate(string:String) {
        navController.navigate(Routes.HomeScreenRoutes.EXPLORE_SCREEN + "/${string}")
    }
    Scaffold(topBar = {
        TopBarSearch(
            navController = navController,
            location,
            address
        ) {
            checkLocation()
        }
    }) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFFF9F8FD), Color(0xFFFFFFFF)
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "What are you",
                fontFamily = encode,
                fontWeight = FontWeight(700),
                fontSize = 40.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(.8f)
            )
            Row {
                Text(
                    text = "looking for, ",
                    fontFamily = encode,
                    fontWeight = FontWeight(700),
                    fontSize = 40.sp,
                )

                Text(
                    text = userName + "?",
                    fontFamily = encode,
                    fontWeight = FontWeight(700),
                    fontSize = 40.sp,
                    color = Color(0xFFFFCF6F),
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Column(
                modifier = Modifier
                    .height(320.dp)
                    .width(320.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeScreenTile(R.drawable.vet, "Veterinary", onClick = { navigate("veterinary") })
                    HomeScreenTile(R.drawable.grooming, "Grooming", onClick = { navigate("grooming") })
                    HomeScreenTile(
                        R.drawable.pet_boarding,
                        "Pet Boarding",
                        onClick = { navigate("pet Boarding") })
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeScreenTile(R.drawable.adoption, "Adoption", onClick = { navigate("adoption") })
                    HomeScreenTile(R.drawable.dog_walking, "Dog Walking", onClick = { navigate("dog Walking") })
                    HomeScreenTile(R.drawable.training, "Training", onClick = { navigate("training") })
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomeScreenTile(R.drawable.pet_taxi, "Pet Taxi", onClick = { navigate("pet Taxi") })
                    HomeScreenTile(R.drawable.pet_date, "Pet Date", onClick = { navigate("pet Date") })
                    HomeScreenTile(R.drawable.other, "Other", onClick = { navigate("other") })
                }
            }
        }
    }
}