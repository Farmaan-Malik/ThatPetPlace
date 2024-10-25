package com.petplace.thatpetplace.homeScreen.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.homeScreen.search.location.LocationData

@Composable
fun TopBarSearch(
    location: LocationData?,
    address: String?,
    trailingFun:()->Unit={},
    onClick: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
    ) {
        ListItem(headlineContent = {
            if (location != null) {
                Text("Home", fontSize = 12.sp)
            } else {
                Text(text = "")
            }
        }, supportingContent = {
            if (location != null) {
                Text("$address", fontSize = 10.sp, overflow = TextOverflow.Ellipsis, modifier = Modifier.fillMaxWidth(.5f))
            } else {
                Text(text = "Location not available", fontSize = 10.sp)
            }
        }, leadingContent = {
            IconButton(onClick = { onClick() }, modifier = Modifier.size(15.dp)) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "location",
                    tint = Color(0xFFFDA8A5)
                )
            }
        }, trailingContent = { IconButton(onClick = {trailingFun() }) {
            Text(text = "Logout", color = Color(0xFFFDA8A5), fontWeight = FontWeight.SemiBold,)
        }}, modifier = Modifier.fillMaxWidth())
    }
}