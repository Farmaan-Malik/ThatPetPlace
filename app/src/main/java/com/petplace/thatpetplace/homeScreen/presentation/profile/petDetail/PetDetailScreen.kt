package com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconToggleButton
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
import com.petplace.thatpetplace.common.components.PrimaryDropdown
import com.petplace.thatpetplace.common.components.PrimaryTextInput
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.AddProfile
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.ColorToggleButton
import com.petplace.thatpetplace.homeScreen.presentation.profile.components.TopBarProfile
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailScreen(
    navController: NavHostController, viewModel: PetDetailViewModel = koinViewModel()
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

    Scaffold(
        topBar = {
            TopBarProfile(title = "Add Pet Details",
                rightText = "Skip",
                navController = navController,
                actionOnclick = { /*TODO*/ })
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 20.dp)
                .fillMaxSize()
                .verticalScroll(enabled = true, state = ScrollState(1))
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
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
                label = "Age",
                value = age,
                onValueChangeEvent = {
                    if (it == "Invalid") {
                        Toast.makeText(context, "Age should be less than 99", Toast.LENGTH_LONG)
                            .show()
                        viewModel.changeAge("")
                    } else
                        viewModel.changeAge(it)
                },
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Additional Information",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Neutered")
                FilledTonalIconToggleButton(checked = isNeutered, onCheckedChange = {viewModel.isNeutered(!isNeutered)}) {

                }
            }
        }

    }
}