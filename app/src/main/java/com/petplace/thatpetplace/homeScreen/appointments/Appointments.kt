package com.petplace.thatpetplace.homeScreen.appointments

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.homeScreen.appointments.components.AppointmentCard
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Appointments(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: AppointmentScreenViewModel = koinViewModel()
) {

    val isLoading by remember {
        viewModel.isLoading
    }
    var appointmentType by remember {
        mutableStateOf("Past")
    }
    val pastAppointment =
        viewModel.appointments.collectAsState()

    Scaffold(backgroundColor = Color(0xFFF8F7FB), topBar = {
        TopBarProfile(
            title = "Appointments",
            navController = navController,
            elevation = 0.dp
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            if (isLoading) {
                LoadingDialogBox()
            } else {
                if (!pastAppointment.value.data.isNullOrEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            //                    .border(2.dp, Color.Black)
                            .padding(
                                top = 10.dp,
                                start = 30.dp,
                                end = 30.dp
                            )
                    ) {

                        items(pastAppointment.value.data!!) { appointment ->
                            AppointmentCard(appointment=appointment,button = appointment.Status == "upcoming")
                        }
                    }
                } else {
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
                            text = "No appointments yet",
                            color = Color(0xFFBBC3CE),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}
