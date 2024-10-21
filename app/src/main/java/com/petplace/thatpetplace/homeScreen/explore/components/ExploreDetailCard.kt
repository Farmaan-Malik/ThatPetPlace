package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.model.ShopResponseItem

@Composable
fun ExploreDetailCard(details:ShopResponseItem,offsetX: Dp, offsetY:Dp) {
    Card(
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .offset(x=offsetX, y=offsetY)
            .height(150.dp)
            .padding(top = 2.dp, bottom = 8.dp)
            .fillMaxWidth(1f)
            .shadow(8.dp, RoundedCornerShape(10))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .padding(16.dp)
            ) {
                Text(
                    text = details.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "141 N Union Ave, Los Angeles, CA",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp
                )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                                .background(Color(0xFFF0F0F8)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
imageVector = Icons.Outlined.Phone,
                                contentDescription = "Phone Number",
                                modifier = Modifier.size(15.dp)
                            )
                        }
                        Text(text =" +91" + details.phone_number)
                    }
                }

            Column(
                modifier = Modifier
                    .padding(end = 20.dp, top = 20.dp, bottom = 20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20))
                        .width(60.dp)
                        .height(60.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color(0xFFFFCB9C), Color(0xFFFDA8A5))
                            )
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text =details.ratings.toString(),
                        fontSize = 35.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                }
                Text(text = details.rating_count.toString(), fontSize = 12.sp)
            }

        }

    }
}