package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R

@Composable
fun ExploreStoresCard(name:String,tagline:String,distance: Float,onClick:()->Unit) {
    Card(
        shape = RoundedCornerShape(8),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(200.dp)
            .padding(top = 2.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
            .shadow(8.dp, RoundedCornerShape(8))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.7f)
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp ),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_profile),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .height(130.dp)
                        .width(130.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(20)),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp, start = 16.dp)
                ) {
                    Text(
                        text = name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "141 N Union Ave, Los Angeles, CA",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Row(modifier = Modifier.padding(top = 12.dp).fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                                .background(Color(0xFFF0F0F8)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.LocationOn,
                                contentDescription = "Distance",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Text(text = distance.toString())
                    }

                }

            }

            Text(
                text ="\"" + tagline + "\"",
                color = Color(0xFFBBC3CE),
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )


        }
    }
}