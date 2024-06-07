package com.petplace.thatpetplace.auth.presentation.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.auth.presentation.common.CircleLogo
import com.petplace.thatpetplace.auth.presentation.common.CustomButton
import com.petplace.thatpetplace.auth.presentation.common.CustomOutlinedInput
import com.petplace.thatpetplace.common.navigation.Routes
import com.petplace.thatpetplace.ui.theme.rozha

@Composable
fun SignUp(
    navHostController: NavHostController
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = { navHostController.navigate(Routes.AuthRoutes.LOGIN_SCREEN) },
        ) {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                    modifier = Modifier.size(35.dp),
                    tint = Color.White
                )
            }
            Text(
                text = "Login", fontSize = 16.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight(600),
                color = Color.White,
            )

        }
    }) { paddingValues ->

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
            Text(
                text = "That Pet Place",
                fontSize = 40.sp,
                fontFamily = rozha,
                color = Color.White,
                modifier = Modifier.padding(bottom = 15.dp)
            )
            CircleLogo()
            Spacer(modifier = Modifier.height(42.dp))
            CustomOutlinedInput(label = "Username")
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(
                label = "Continue",
                onClick = { navHostController.navigate(Routes.AuthRoutes.SIGNUP_DETAILS_SCREEN) })
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .width(360.dp),
                Alignment.Center
            ) {
                Divider(color = Color(0x57302D2D), modifier = Modifier.width(370.dp))
                Text(
                    text = "or use",
                    modifier = Modifier
                        .width(60.dp)
                        .background(Color.White),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    color = Color(
                        0x881F1E1E
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(50.dp),
                horizontalArrangement = Arrangement.Absolute.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon),
                        contentDescription = "Google", Modifier.size(30.dp),
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .padding(8.dp)
                        .clip(
                            CircleShape
                        )
                        .border(2.dp, Color(0xFF0C3C77), CircleShape)
                        .width(32.dp)
                        .height(32.dp)

                        .background(Color(0xFF0C3C77))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.fb),
                        contentDescription = "Google", Modifier.fillMaxSize(),
                        tint = Color.White
                    )
                }

            }
        }
    }
}