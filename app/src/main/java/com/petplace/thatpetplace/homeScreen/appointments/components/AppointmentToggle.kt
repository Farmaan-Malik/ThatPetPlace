package com.petplace.thatpetplace.homeScreen.appointments.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppointmentToggle(width: Float = 1f, title: String, isSelected: Boolean, onClick: () -> Unit) {


    Button(
        onClick = {
            onClick()

        },
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(width)
            .shadow(if(isSelected) 8.dp else 0.dp ,shape = RoundedCornerShape(50)),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFFFDA8A5) else Color.White
        )
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = if (isSelected) Color.White else Color.Black
        )

    }
}