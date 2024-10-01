package com.petplace.thatpetplace.homeScreen.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R

@Composable
fun ExploreClinicsCard(onClick:()->Unit={}) {
    Card(
        shape = RoundedCornerShape(8),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(120.dp)
            .padding(top = 2.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
            .width(250.dp)
            .shadow(8.dp, RoundedCornerShape(8))
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_profile),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(20)),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp, start = 8.dp)
                ) {
                    Text(
                        text = "Alekseenko Vasily",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Little Paws Clinic",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Veterinary Dentist",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
//                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(15.dp)
                                    .background(Color(0xFFF0F0F8)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.LocationOn,
                                    contentDescription = "Distance",
                                    modifier = Modifier.size(10.dp)
                                )
                            }
                            Text(text = "1.5km")
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Row {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(15.dp)
                                    .background(Color(0xFFF0F0F8)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.wallet),
                                    contentDescription = "Fees",
                                    modifier = Modifier.size(5.dp)
                                )
                            }
                            Text(text = "$20")
                        }
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                Text(
                    text = "7",
                    color = Color(0xFFBBC3CE),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(text = " years of experience", color = Color(0xFFBBC3CE), fontSize = 12.sp)

            }
        }
    }
}