package com.petplace.thatpetplace.auth.presentation.common.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(label: String,onClick:()-> Unit) {
    Button(
        onClick = { onClick() }, modifier = Modifier
            .shadow(
                elevation = 5.dp,
                ambientColor = Color.Black,
                spotColor = Color.Black,
                shape = RoundedCornerShape(5.dp)
            )
            .width(350.dp)
            .height(50.dp),
        shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(Color(0xFFFDA8A5))
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.White,
            letterSpacing = 2.sp
        )
    }

}