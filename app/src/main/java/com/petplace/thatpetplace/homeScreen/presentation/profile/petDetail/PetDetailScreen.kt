package com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail

import android.annotation.SuppressLint
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
import com.petplace.thatpetplace.common.components.PrimaryDropdown
import com.petplace.thatpetplace.common.components.PrimaryTextInput
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.AddProfile
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.ColorToggleButton
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.CustomSwitch
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PetDetailScreen(
    navController: NavHostController, viewModel: PetDetailViewModel = koinViewModel(), paddingValues: PaddingValues
) {
    val context = LocalContext.current
    val petsName by remember {
        viewModel.petsName
    }
    val species by remember {
        viewModel.species
    }
    val breed by remember {
        viewModel.breed
    }
    val gender by remember {
        viewModel.gender
    }
    val age by remember {
        viewModel.age
    }
    val isNeutered by remember {
        viewModel.neutered
    }
    val isVaccinated by remember {
        viewModel.vaccinated
    }

Scaffold(topBar = {
    TopBarProfile(
    title ="ADP",
    rightText ="Skip",
    navController =navController
) {
/*TODO*/
}
}) {it
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
                .padding(top = paddingValues.calculateTopPadding())
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            horizontalArrangement = Arrangement.Center

        ) {
            AddProfile()
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "General \nInformation",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 25.sp
        )

        PrimaryTextInput(label = "Pet's name",
            value = petsName,
            onValueChangeEvent = { viewModel.changeName(it) })
        PrimaryDropdown(
            selectedValue = species,
            options = listOf("asd", "sad"),
            label = "Species of your pet",
            onValueChangedEvent = { viewModel.changeSpecies(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        PrimaryDropdown(
            selectedValue = breed,
            options = listOf("asd", "sad"),
            label = "Breed of your pet",
            onValueChangedEvent = { viewModel.changeBreed(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
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
                onClick = { viewModel.changeGender("Male") },
                label = "Male",
                selected = gender == "Male"
            )
            ColorToggleButton(
                onClick = { viewModel.changeGender("Female") },
                label = "Female",
                selected = gender == "Female"
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        PrimaryTextInput(
            label = "Age", value = age, onValueChangeEvent = {
                if (it == "Invalid") {
                    Toast.makeText(context, "Age should be less than 99", Toast.LENGTH_LONG)
                        .show()
                    viewModel.changeAge("")
                } else viewModel.changeAge(it)
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

            CustomSwitch(isSelected = isNeutered, text = "Neutered", onChange = {
                viewModel.isNeutered(
                    !isNeutered
                )
            })
            CustomSwitch(
                isSelected = isVaccinated,
                text = "Vaccinated",
                onChange = { viewModel.isVaccinated(!isVaccinated) })

            CustomButton(label = "Next") {
                /*TODO*/
            }



        }


    }
}




    }
