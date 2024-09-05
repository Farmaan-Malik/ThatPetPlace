package com.petplace.thatpetplace.homeScreen.presentation.profile.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R

@Composable
fun ColorToggleButton(onClick: ()-> Unit, label: String, selected:Boolean) {
    Button(
        onClick = { onClick() }, modifier = Modifier
            .shadow(
                elevation = if (selected){5.dp} else 2.dp,
                ambientColor = Color.Black,
                spotColor = Color.Black,
                shape = RoundedCornerShape(30.dp)
            )
            .height(50.dp)
            .width(150.dp)
            ,
        shape = RoundedCornerShape(30.dp), colors = ButtonDefaults.buttonColors(if (selected) Color(0xFFFDA8A5) else Color.White)
    ) {
        Icon(painter = painterResource(id =R.drawable.male )
            , contentDescription ="", tint =  if (selected){Color.White} else
        Color(0xFFFDA8A5))
        Text(
            text = label,
            fontSize = 14.sp,
            color = if (selected) Color.White else Color.Black,
            letterSpacing = 2.sp
        )
    }
}