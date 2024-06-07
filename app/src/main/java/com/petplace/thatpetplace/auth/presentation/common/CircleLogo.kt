package com.petplace.thatpetplace.auth.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.petplace.thatpetplace.R

@Composable
fun CircleLogo() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 8.dp,
                    ambientColor = Color.Black,
                    spotColor = Color.Black,
                    shape = CircleShape
                )
                .width(350.dp)
                .height(350.dp)
                .align(Alignment.Center)

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .width(417.dp)
                    .height(417.dp)
            )
        }
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.Center)
                .width(350.dp)
                .height(350.dp)
                .offset(x = -10.dp, y = 1.dp)
                .border(1.dp, Color.White, CircleShape)
                .zIndex(-1f)

        ) {

        }
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.Center)
                .width(350.dp)
                .height(350.dp)
                .offset(x = -6.dp, y = 10.dp)
                .border(1.dp, Color.White, CircleShape)
                .zIndex(-1f)

        ) {

        }
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.Center)
                .width(360.dp)
                .height(360.dp)
                .offset(x = 2.dp, y = -8.dp)
                .border(1.dp, Color.White, CircleShape)
                .zIndex(-1f)

        ) {

        }
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .align(Alignment.Center)
                .width(360.dp)
                .height(360.dp)
                .offset(x = 6.dp, y = -2.dp)
                .border(1.dp, Color.White, CircleShape)
                .zIndex(-1f)

        ) {

        }
    }
}