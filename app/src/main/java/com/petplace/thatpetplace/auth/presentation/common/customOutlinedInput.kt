package com.petplace.thatpetplace.auth.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomOutlinedInput(label:String) {
    val textState = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .width(350.dp)
            .height(57.dp),
        label = { Text(text = label)},
        singleLine = true,
        value = textState.value,
        onValueChange = {textState.value = it},
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