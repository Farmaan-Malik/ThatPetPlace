package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R

@Composable
fun ProductCounter() {
Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(painter = painterResource(id = R.drawable.subtract), contentDescription = "subtract")
    }
    Text(text = "0", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = "subtract")
    }

}
}

@Preview
@Composable
private fun CounterPreview() {
    ProductCounter()
}