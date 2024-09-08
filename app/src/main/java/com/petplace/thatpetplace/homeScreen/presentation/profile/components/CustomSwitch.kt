package com.petplace.thatpetplace.homeScreen.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun CustomSwitch(isSelected : Boolean, onChange: ()-> Unit, text:String) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, fontSize = 18.sp)
        Switch(
            checked = isSelected,
            onCheckedChange = { onChange() },
            colors = SwitchDefaults.colors(
                uncheckedBorderColor = Color.White,
                uncheckedThumbColor = Color.White,
                disabledUncheckedBorderColor = Color(
                    0xFFF5F5F5
                ),
                uncheckedTrackColor =Color(0x95D1CCE8),
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFFFDA8A5),
            )
        )
    }



}