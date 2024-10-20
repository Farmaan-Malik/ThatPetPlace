package com.petplace.thatpetplace.homeScreen.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.search.location.LocationData

@Composable
fun TopBarSearch(navController: NavHostController, location: LocationData?, address: String?, onClick:()->Unit={}) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
    ) {
        ListItem(headlineContent = {
            if (location != null) {
                Text("Home",fontSize = 12.sp)
            } else {
                Text(text = "")
            }
        }, supportingContent = {
            if (location != null) {
                Text("$address", fontSize = 10.sp, overflow = TextOverflow.Ellipsis)
            } else {
                Text(text = "Location not available",fontSize = 10.sp)
            }
        }, leadingContent = {
            IconButton(onClick = { onClick() }, modifier = Modifier.size(15.dp)) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "location",
                    tint = Color(0xFFFDA8A5)
                )
            }
        }, modifier = Modifier.fillMaxWidth(.5f))
        IconButton(
            onClick = { navController.navigate(Routes.HomeScreenRoutes.CART_SCREEN) },
            modifier = Modifier.fillMaxHeight()
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Cart",
                tint = Color(0xFFFDA8A5)
            )
        }
    }
}