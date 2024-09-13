package com.petplace.thatpetplace.homeScreen.appointments

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.appointments.components.AppointmentCard
import com.petplace.thatpetplace.homeScreen.appointments.components.AppointmentToggle
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Appointments(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: AppointmentScreenViewModel = koinViewModel()
) {
    val appointmentType = remember {
        mutableStateOf("Past")
    }
    val pastAppointment = remember {
        viewModel.pastAppointment.value
    }
    val upcomingAppointment = remember {
        viewModel.upcomingAppointment.value
    }


    Scaffold(backgroundColor = Color(0xFFF8F7FB)) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom =  paddingValues.calculateBottomPadding())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .shadow(
                        8.dp, RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20)
                    )
                    .clip(RoundedCornerShape(bottomStartPercent = 20, bottomEndPercent = 20))
                    .background(Color.White), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Appointments",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,

                    )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                        .height(40.dp)
                        .border(1.dp, Color(0xFFE4E3F3), RoundedCornerShape(50))
                        .background(Color.White)
                ) {
                    AppointmentToggle(
                        title = "Upcoming",
                        isSelected = appointmentType.value == "Upcoming",
                        width = .5f
                    ) {
                        appointmentType.value = "Upcoming"
                        /*TODO*/
                    }
                    AppointmentToggle(
                        title = "Past", isSelected = appointmentType.value == "Past", width = 1f
                    ) {
                        appointmentType.value = "Past"
                        /*TODO*/

                    }

                }

            }


            if (appointmentType.value == "Past" && pastAppointment.isNotEmpty() || appointmentType.value =="Upcoming" && upcomingAppointment.isNotEmpty()) {
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
                    if (appointmentType.value == "Past"){
                        items(4){
                            AppointmentCard(button = false)
                        }
                    }
                    else{
                        items(2){
                          AppointmentCard()
                        }
                    }


                }

            } else if (appointmentType.value == "Past" && pastAppointment.isEmpty() || appointmentType.value == "Upcoming" && upcomingAppointment.isEmpty()) {
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
                    Text(text = "No appointments yet", color = Color(0xFFBBC3CE), fontSize = 20.sp)

                }
            }
        }
    }
}