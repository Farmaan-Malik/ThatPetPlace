package com.petplace.thatpetplace.homeScreen.presentation.profile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TopBarProfile(
    title: String,
    rightText: String,
    navController: NavHostController,
    actionOnclick: () -> Unit
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = rightText,
                    tint = Color(0xFFFDA8A5)
                )
            }
        },
        backgroundColor = Color.White,
        actions = {
            Button(
                onClick = { actionOnclick() },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = rightText,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFDA8A5)
                )
            }
        })
}
