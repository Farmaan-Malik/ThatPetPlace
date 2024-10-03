package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.petplace.thatpetplace.R

@Composable
fun CartItem(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .shadow(8.dp, RoundedCornerShape(topEndPercent = 20, bottomStartPercent = 20))
            .background(Color.White, RoundedCornerShape(topEndPercent = 20, bottomStartPercent = 20))
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = R.drawable.product_placeholder),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(90.dp)
                .width(90.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(bottomStartPercent = 20))
        )
        Column(
            modifier = Modifier
                .padding(start = 6.dp, top = 8.dp)
                .fillMaxHeight()
                .fillMaxWidth(.85f), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Product Name",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row {
                Text(text = "Quantity: ", fontWeight = FontWeight.SemiBold)
                Text(text = "2")
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Price: ", fontWeight = FontWeight.SemiBold)
                Text(text = "Rs " + "200", fontSize = 12.sp)
            }
        }
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Remove from cart",
                    tint = Color(0xFFFF6600)
                )
            }
        }
    }
}