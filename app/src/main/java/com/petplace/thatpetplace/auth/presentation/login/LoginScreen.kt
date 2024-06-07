package com.petplace.thatpetplace.auth.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.auth.presentation.common.CircleLogo
import com.petplace.thatpetplace.auth.presentation.common.CustomButton
import com.petplace.thatpetplace.auth.presentation.common.CustomButtonLow
import com.petplace.thatpetplace.auth.presentation.common.CustomFont
import com.petplace.thatpetplace.auth.presentation.common.CustomOutlinedInput
import com.petplace.thatpetplace.auth.presentation.common.CustomPasswordInput
import com.petplace.thatpetplace.common.navigation.Routes
import com.petplace.thatpetplace.ui.theme.alegrya

@Composable
fun LoginScreen(
    navHostController: NavHostController
) {
    var username = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFFFDA8A5),
                            Color(0xFFFFCB9C),
                        )
                    )
                )
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(modifier = Modifier.height(42.dp))
            CustomFont("That Pet Place", 40.sp)
            Spacer(modifier = Modifier.height(18.dp))
            CircleLogo()
            Spacer(modifier = Modifier.height(10.dp))
            CustomOutlinedInput("Email or Username")
            Spacer(modifier = Modifier.height(10.dp))
            CustomPasswordInput(label = "Password")
            Spacer(modifier = Modifier.height(15.dp))
            CustomButton(label = "Login", onClick = {/*TODO*/})
            Text(
                text = "Don't Have An Account ?",
                fontFamily = alegrya,
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))


            CustomButtonLow(label = "Sign up"){
                navHostController.navigate(Routes.AuthRoutes.SIGNUP_SCREEN)
            }
        }
    }
}