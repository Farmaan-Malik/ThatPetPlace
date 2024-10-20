package com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.common.components.LoadingDialogBox
import com.petplace.thatpetplace.common.components.PrimaryDropdown
import com.petplace.thatpetplace.common.components.PrimaryTextInput
import com.petplace.thatpetplace.homeScreen.profile.components.AddProfile
import com.petplace.thatpetplace.homeScreen.profile.components.ColorToggleButton
import com.petplace.thatpetplace.homeScreen.profile.components.CustomSwitch
import com.petplace.thatpetplace.homeScreen.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PetDetailScreen(
    navController: NavHostController,
    viewModel: PetDetailViewModel = koinViewModel(),
    paddingValues: PaddingValues
) {
    val isLoading by remember {
        viewModel.isLoading
    }
    val isSuccess by remember {
        viewModel.isSuccess
    }
    val isError by remember {
        viewModel.isError
    }
    val context = LocalContext.current
    val petsName = remember {
        mutableStateOf("")
    }
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }
    val species = remember {
        mutableStateOf("")
    }
    val breed = remember {
        mutableStateOf("")
    }
    val gender = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }
    val isNeuter = remember {
        mutableStateOf(
            false
        )
    }
    val isVaccinated = remember {
        mutableStateOf(
            false
        )
    }

    Scaffold(topBar = {
        TopBarProfile(
            title = "Add Pet Profile",
//            rightText = "Skip",
            navController = navController
        )
    }) {
        if (isLoading) {
            LoadingDialogBox()
        } else {
//            if (isError) {
//                Toast.makeText(LocalContext.current, "An error occurred", Toast.LENGTH_LONG)
//                    .show()
//            } else {
//                if (!isSuccess.value){
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
                if (isSuccess) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = paddingValues.calculateTopPadding() + 8.dp)
                            .background(Color.White), horizontalArrangement = Arrangement.Center

                    ) {
                        AddProfile(viewModel = viewModel)
                    }
                    CustomButton(label = "Submit") {
                        viewModel.uploadPhoto()
                    }
                } else {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "General \nInformation",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 25.sp
                    )

                    PrimaryTextInput(
                        label = "Pet's name",
                        value = petsName.value,
                        onValueChangeEvent = {
                            Log.e("Pre-change", petsName.value)
                            petsName.value = it
                            Log.e("Post-change", petsName.value)
                            viewModel.changeName(petsName.value)
                        })
                    PrimaryDropdown(
                        selectedValue = species.value,
                        options = listOf("asd", "sad"),
                        label = "Species of your pet",
                        onValueChangedEvent = {
                            species.value = it
                            viewModel.changeSpecies(it)

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    )
                    PrimaryTextInput(
                        label = "Breed of your pet",
                        value = breed.value,
                        onValueChangeEvent = {
                            Log.e("Pre-change", petsName.value)
                            breed.value = it
                            Log.e("Post-change", petsName.value)
                            viewModel.changeBreed(breed.value)
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
                            selected = gender.value == "Male",
                            isIcon = true,
                            icon = R.drawable.male
                        )
                        ColorToggleButton(
                            onClick = {
                                gender.value = "Female"
                                viewModel.changeGender("Female")

                            },
                            label = "Female",
                            selected = gender.value == "Female",
                            isIcon = true,
                            icon = R.drawable.female
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryTextInput(
                        label = "Age", value = age.value.toString(), onValueChangeEvent = {
                            if (it.length > 3) {
                                Toast.makeText(
                                    context, "Age should be less than 99", Toast.LENGTH_LONG
                                ).show()
                                age.value = ""
                                viewModel.changeAge("")
                            } else age.value = it
                            viewModel.changeAge(it)
                        }, keyboardType = KeyboardType.Number
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Additional Information",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Column {

                        CustomSwitch(isSelected = isNeuter.value, text = "Neutered", onChange = {
                            Log.e("pre-click", isNeuter.value.toString())
                            isNeuter.value = !isNeuter.value
                            viewModel.isNeutered(
                                isNeuter.value
                            )
                            Log.e("post-clicked", isNeuter.value.toString())

                        })
                        CustomSwitch(
                            isSelected = isVaccinated.value,
                            text = "Vaccinated",
                            onChange = {
                                isVaccinated.value = !isVaccinated.value
                                viewModel.isVaccinated(!isVaccinated.value)

                            })

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButton(label = "Next") {
                                viewModel.addPet()
                                Log.e("userid", viewModel.string.value)
                            }
                        }
                    }

                }
            }

        }
    }
}