package com.petplace.thatpetplace.auth.presentation.common.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomOutlinedInput(label:String,value:MutableState<String>) {
    val textState = remember {
        mutableStateOf("")
    }
    fun update(){
        value.value = textState.value
    }
    OutlinedTextField(
        modifier = Modifier
            .width(350.dp)
            .height(57.dp),
        label = { Text(text = label)},
        singleLine = true,
        value = textState.value,
        onValueChange = {
                        textState.value = it
            update()

        },
        textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color(0xFFFDA8A5),
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.White,
            focusedContainerColor = Color.Transparent,
        ),
    )
}