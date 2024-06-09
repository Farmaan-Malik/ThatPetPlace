package com.petplace.thatpetplace.auth.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R

@Composable
fun CustomPasswordInput(label: String,value: MutableState<String>) {
    val passwordText = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    fun update(){
        value.value = passwordText.value
    }
    fun setVisibility() {
        passwordVisible.value = !passwordVisible.value
    }
    OutlinedTextField(
        modifier = Modifier
            .width(350.dp)
            .height(57.dp),
        singleLine = true,
        trailingIcon = {
            IconButton(onClick = { setVisibility() }) {
                if (passwordVisible.value) {
                    Image(
                        painter = painterResource(id = R.drawable.showpassword),
                        contentDescription = "show Password"
                    )
                }else
                    Image(
                        painter = painterResource(id = R.drawable.hidepassword),
                        contentDescription = "hide Password"
                    )

            }
        },
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        value = passwordText.value,
        onValueChange = { passwordText.value = it
                        update()},
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

