package com.petplace.thatpetplace.homeScreen.appointments.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun AppointmentCard(button: Boolean = true) {
    Card(
        shape = RoundedCornerShape(8),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(350.dp)
            .padding(top = 30.dp, bottom = 8.dp)
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(8))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.4f)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_profile),
                    contentDescription = "Profile Photo",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(20)),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Alekseenko Vasily",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = "Veterinary Dentist",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
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
                            Text(text = "1.5km")
                        }
                        Spacer(modifier = Modifier.width(40.dp))
                        Row {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(25.dp)
                                    .background(Color(0xFFF0F0F8)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.wallet),
                                    contentDescription = "Fees",
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                            Text(text = "$20")
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxHeight(.65f)
                    .fillMaxWidth()
                    .background(Color(0xFFF8F7FB), RoundedCornerShape(20))
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(.5f)
//    .border(2.dp, Color.Black)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(50.dp)
                            .background(Color(0xFFF0F0F8)), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.work),
                            contentDescription = "Fees",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
//                            .border(2.dp, Color.Red)
                    ) {
                        Text(
                            text = "Veterinary clinic \"Alden-Vet\"",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "141 N Union Ave, Los Angeles, CA",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(.5f)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(50.dp)
                            .background(Color(0xFFF0F0F8)), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock_outlined),
                            contentDescription = "Fees",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "Wed 9 Sep — 10:30 am",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }

                }
            }
            if (button) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AppointmentToggle(title = "Pay", isSelected = true, width = .5f) {
                        /*TODO*/
                    }
                    AppointmentToggle(title = "Cancel", isSelected = false) {
                        /*TODO*/
                    }
                }
            }
        }
    }
}