package com.petplace.thatpetplace.homeScreen.profile.presentation.profileDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.common.components.PrimaryTextInput
import com.petplace.thatpetplace.homeScreen.profile.components.AddProfile
import com.petplace.thatpetplace.homeScreen.profile.components.ColorToggleButton
import com.petplace.thatpetplace.homeScreen.profile.components.CustomAlertDialog
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@Composable
fun Profile(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: ProfileScreenViewModel = koinViewModel()
) {
    val showDialog = remember {
        mutableStateOf(true)
    }
    val gender = remember {
        mutableStateOf("")
    }
    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val phoneNumber = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }

    Scaffold(topBar = {
        TopBarProfile(
            title = "Your Profile",
            navController = navController
        )
    }) {
        it
        CustomAlertDialog(showBottomSheet = showDialog.value, onDismiss = {
            showDialog.value = false
        }, onAdd = { navController.navigate(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) })

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(
                    top = paddingValues.calculateTopPadding() + it.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .padding(horizontal = 20.dp)
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(top = paddingValues.calculateTopPadding() + 8.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center

            ) {
                AddProfile(viewModel = viewModel)
            }
            Spacer(modifier = Modifier.height(32.dp))
            PrimaryTextInput(label = "First name",
                value = firstName.value,
                verified = true,
                onValueChangeEvent = {
                    firstName.value = it
                    viewModel.changeFirstName(firstName.value)
                })
            PrimaryTextInput(label = "Last name",
                value = lastName.value,
                verified = true,
                onValueChangeEvent = {
                    lastName.value = it
                    viewModel.changeLastName(lastName.value)
                })
            Text(
                text = "Gender",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                fontSize = 13.sp,
                color = Color(0xFFBBC3CE)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 13.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ColorToggleButton(
                    onClick = {
                        gender.value = "Male"
                        viewModel.changeGender("Male")
                    },
                    label = "Male",
                    selected = gender.value == "Male", isIcon = true, icon = R.drawable.male
                )
                ColorToggleButton(
                    onClick = {
                        gender.value = "Female"
                        viewModel.changeGender("Female")
                    },
                    label = "Female",
                    selected = gender.value == "Female", isIcon = true, icon = R.drawable.female
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            PrimaryTextInput(label = " Email",
                value = email.value,
                verified = false,
                onValueChangeEvent = {
                    email.value = it
                    viewModel.changeEmail(email.value)
                })
            PrimaryTextInput(label = "Phone Number (+91)",
                value = phoneNumber.value,
                onValueChangeEvent = {
                    phoneNumber.value = it
                    viewModel.changePhoneNumber(phoneNumber.value)
                }, keyboardType = KeyboardType.Number
            )

        }
        Box(
            Modifier
                .fillMaxHeight()
                .padding(bottom = paddingValues.calculateBottomPadding()),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                CustomButton(label = "Save") {
                    navController.navigate(Routes.HomeScreenRoutes.PROFILE_VIEW_SCREEN)
                    /*TODO*/
                }
            }
        }
    }
}