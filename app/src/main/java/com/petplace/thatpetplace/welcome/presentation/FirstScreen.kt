package com.petplace.thatpetplace.welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.ui.theme.encode
import com.petplace.thatpetplace.ui.theme.encodeNormal
import com.petplace.thatpetplace.welcome.common.PageIndicator

@Composable
fun FirstScreen( navHostController: NavHostController) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.illustration),
                contentDescription = "Welcome Images",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                Alignment.Center
            ) {
                PageIndicator(pageCount = 3, currentPage = 0)
            }
            Text(
                text = "Welcome to Pet Care",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontFamily = encode,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "All types of services for your pet in one\n" +
                        " place, instantly searchable.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = encodeNormal,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(48.dp))
            Button(
                onClick = { navHostController.navigate(Routes.WelcomeRoutes.SECOND_SCREEN) },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(Color(0xFFFDA8A5)),
                modifier = Modifier.width(260.dp).height(46.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}