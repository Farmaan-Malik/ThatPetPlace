package com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.common.components.PrimaryTextInput
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.componenets.PetDropDown
import com.petplace.thatpetplace.homeScreen.explore.presentation.BookAppointment.data.model.NewAppointmentPayload
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAppointments(
    doctorName: String,
    qualification: String,
    fees: Float,
    clinicID: String,
    paddingValues: PaddingValues,
    viewModel: BookAppointmentViewModel = koinViewModel(),
    onBackPress: () -> Unit
) {
    val selectedPet = remember {
        mutableStateOf("")
    }
    val petList by remember {
        viewModel.listOfPetsName
    }
    val isLoading by remember {
        viewModel.isLoading
    }
    val userId by remember {
        viewModel.string
    }
    val date = remember {
        mutableStateOf("")
    }
    Scaffold(
        backgroundColor = Color(
            0xFFF8F7FB
        ),
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
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Doctor's Name: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = doctorName,
                                fontSize = 18.sp,
                                fontStyle = FontStyle.Italic
                            )

                        }
                    }, supportingContent = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Fee: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = "$$fees",
                                fontSize = 18.sp
                            )
                        }
                    },
                        overlineContent = {
                            Text(
                                text = qualification,
                                fontSize = 18.sp
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
                            .padding(top = 8.dp)
                    )
                    PrimaryTextInput(label = "Date(dd/mm/yy)", value = date.value) {
                        date.value = it
                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomButton(label = "Confirm Booking") {

                        viewModel.bookAppointment(
                            NewAppointmentPayload(
                                DoctorName = doctorName,
                                AppointmentDate = date.value,
                                PetName = selectedPet.value,
                                UserID = userId,
                                Status = "Upcoming",
                                CLinicID= clinicID,
                                DoctorQualification = qualification,
                                Price = fees.toInt()
                            )
                        )
                    }
                }
            }
        }
    }
}