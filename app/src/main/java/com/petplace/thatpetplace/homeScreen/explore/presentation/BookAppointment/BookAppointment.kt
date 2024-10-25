package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.componenets.PetDropDown
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookAppointments(
    clinicName:String,
    availableDays: List<String>,
    navController: NavHostController,
    doctorName: String,
    qualification: String,
    fees: Float,
    clinicID: String,
    paddingValues: PaddingValues,
    viewModel: BookAppointmentViewModel = koinViewModel(),
    onBackPress: () -> Unit
) {
    val localContext=LocalContext.current
    val selectedPet = remember {
        mutableStateOf("")
    }
    val petList by remember {
        viewModel.listOfPetsName
    }
    val isLoading by remember {
        viewModel.isLoading
    }
    val isSuccess by remember {
        viewModel.isSuccess
    }
    val userId by remember {
        viewModel.string
    }
    val date = remember {
        mutableStateOf("")
    }
    Scaffold(
        backgroundColor = Color(0xFFFDA8A5),
        topBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { onBackPress() }) {
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Go Back")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding() + it.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            if (isLoading) {
                LoadingDialogBox()
            } else {


                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        .fillMaxWidth()
                        .height(400.dp)
                        .shadow(8.dp, RoundedCornerShape(20.dp))
                        .background(
                            Color.White, shape = RoundedCornerShape(20.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.user_profile),
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
                    Box(modifier = Modifier.fillMaxSize().padding(top = 18.dp), contentAlignment = Alignment.TopCenter){
                        Text(text = clinicName.uppercase(), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFCF6F) )

                    }
                }
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(.7f)
                        .shadow(8.dp, RoundedCornerShape(20.dp))
                        .background(
                            Color.White, shape = RoundedCornerShape(20.dp)
                        )
                ) {
                    ListItem(headlineContent = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Doctor's Name: ",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = doctorName,
                                fontSize = 16.sp,
                            )

                        }
                    }, supportingContent = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = "Fee: ",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                            )
                            Text(
                                text = "$$fees",
                                fontSize = 16.sp
                            )
                        }
                    },
                        overlineContent = {
                            Text(
                                text = qualification,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.SemiBold
                            )
                        })
                    PetDropDown(
                        selectedValue = selectedPet.value,
                        options = petList,
                        label = "Select Pet",
                        onValueChangedEvent = {
                            selectedPet.value = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Available this week on ..",
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth(.8f)
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    LazyRow(modifier = Modifier.padding(horizontal = 16.dp)) {
                        items(availableDays) { x ->
                            IconButton(
                                onClick = { date.value = x.uppercase() },
                                modifier = Modifier
                                    .width(80.dp)
                                    .height(20.dp)
                                    .padding(start = 8.dp),
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = Color(
                                        0x7CBBC3CE
                                    )
                                )
                            ) {
                                Text(text = x.uppercase(), fontSize = 12.sp)
                            }
                        }
                    }
                    Text(
                        text = "Selected Day: ${date.value}",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomButton(label = "Confirm Booking") {
                        if (selectedPet.value == "" || date.value == "") {
                            Toast.makeText(localContext, "Fill all fields", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            viewModel.bookAppointment(
                                NewAppointmentPayload(
                                    doctor_name = doctorName,
                                    appointment_date = date.value,
                                    pet_name = selectedPet.value,
                                    user_id = userId,
                                    status = "Upcoming",
                                    clinic_id = clinicID,
                                    doctor_qualification = qualification,
                                    price = fees
                                )
                            )
                                .invokeOnCompletion { navController.navigate(Routes.HomeScreenRoutes.APPOINTMENT_SCREEN) }
                        }
                    }
                }
            }
        }
    }
}