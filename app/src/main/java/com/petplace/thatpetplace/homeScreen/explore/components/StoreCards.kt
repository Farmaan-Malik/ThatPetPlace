package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun StoreCards(backgroundImage: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 8.dp)
            .background(Color.White, shape = RoundedCornerShape(topStartPercent = 20, topEndPercent = 20))
            .clip(
                RoundedCornerShape(
                    topStartPercent = 20, topEndPercent = 20
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = backgroundImage),

            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .aspectRatio(1f)

        )
        Text(
            text = "Product Name",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = "Product good. Product help Hulk. Hulk Happy if you buy.",
            fontSize = 14.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(bottom = 16.dp, start =  8.dp, end = 8.dp)
        )
        Text(
            text = "Price: " + "12Rs",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}