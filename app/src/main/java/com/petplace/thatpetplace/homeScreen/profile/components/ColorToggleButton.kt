package com.petplace.thatpetplace.homeScreen.profile.components

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorToggleButton(onClick: ()-> Unit, label: String, selected:Boolean, isIcon:Boolean = false,icon:Int = 0, width: Dp = 150.dp,height: Dp = 50.dp) {
    Button(
        onClick = { onClick() }, modifier = Modifier
            .shadow(
                elevation = if (selected){5.dp} else 2.dp,
                ambientColor = Color.Black,
                spotColor = Color.Black,
                shape = RoundedCornerShape(30.dp)
            )
            .height(height)
            .width(width)
            ,
        shape = RoundedCornerShape(30.dp), colors = ButtonDefaults.buttonColors(if (selected) Color(0xFFFDA8A5) else Color.White)
    ) {
       if (isIcon){
           Icon(painter = painterResource(id =icon )
               , contentDescription ="", tint =  if (selected){Color.White} else
                   Color(0xFFFDA8A5))
       }

        Text(
            text = label,
            fontSize = 14.sp,
            color = if (selected) Color.White else Color.Black,
            letterSpacing = 2.sp
        )
    }
}