package com.petplace.thatpetplace.auth.presentation.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.ui.theme.rozha

@Composable
fun PetPlaceText() {
    Text(
        text = "That Pet Place",
        modifier = Modifier
            .width(348.dp)
            .height(71.dp),
//                    .border(2.dp, Color.Black),
        color = Color.White,
        fontFamily = rozha,
        style = TextStyle(
            shadow = Shadow(
                blurRadius = 4.0f,
                color = Color.Black,
                offset = Offset(y = 4.0f, x = 0.0f)
            )
        ),
        textAlign = TextAlign.Center,
        fontSize = 40.sp
    )
}