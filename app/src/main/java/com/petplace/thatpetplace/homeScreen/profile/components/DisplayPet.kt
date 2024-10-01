package com.petplace.thatpetplace.homeScreen.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.petplace.thatpetplace.R

@Composable
fun DisplayPet(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(80.dp)
            .width(80.dp)
            .shadow(
                8.dp,
                shape = RoundedCornerShape(20)
            )
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.petprofile_placeholder2),
            contentDescription = "Pet photo",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }
}