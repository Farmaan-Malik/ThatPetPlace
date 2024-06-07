package com.petplace.thatpetplace.auth.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.CircleLogo
import com.petplace.thatpetplace.auth.presentation.common.CustomButton
import com.petplace.thatpetplace.auth.presentation.common.CustomButtonLow
import com.petplace.thatpetplace.auth.presentation.common.CustomOutlinedInput
import com.petplace.thatpetplace.auth.presentation.common.CustomPasswordInput
import com.petplace.thatpetplace.auth.presentation.common.PetPlaceText
import com.petplace.thatpetplace.ui.theme.alegrya
import com.petplace.thatpetplace.ui.theme.rozha

@Composable
fun LoginScreen() {
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
            PetPlaceText()
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
            CustomButtonLow(label = "Sign up", onClick = {/*TODO*/})
        }
    }
}