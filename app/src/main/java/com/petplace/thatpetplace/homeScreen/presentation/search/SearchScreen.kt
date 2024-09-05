package com.petplace.thatpetplace.homeScreen.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.components.HomeScreenTile
import com.petplace.thatpetplace.ui.theme.encode

@Composable
fun SearchScreen() {
    Scaffold(topBar = {

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(8.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxHeight()) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search",
                        tint = Color(0xFFFDA8A5)
                    )
                }
            }

    }) {paddingValues->

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding())
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFFF9F8FD), Color(0xFFFFFFFF)
                    )
                )
            )
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "What are you",
            fontFamily = encode,
            fontWeight = FontWeight(700),
            fontSize = 40.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(.8f)
        )
        Row {
            Text(
                text = "looking for, ",
                fontFamily = encode,
                fontWeight = FontWeight(700),
                fontSize = 40.sp,
            )

            Text(
                text = "Maria?",
                fontFamily = encode,
                fontWeight = FontWeight(700),
                fontSize = 40.sp,
                color = Color(0xFFFFCF6F),
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Column(
            modifier = Modifier
                .height(320.dp)
                .width(320.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeScreenTile(R.drawable.vet, "Veterinary", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.grooming, "Grooming", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.pet_boarding, "Pet Boarding", onClick = {/*Todo*/ })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeScreenTile(R.drawable.adoption, "Adoption", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.dog_walking, "Dog Walking", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.training, "Training", onClick = {/*Todo*/ })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HomeScreenTile(R.drawable.pet_taxi, "Pet Taxi", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.pet_date, "Pet Date", onClick = {/*Todo*/ })
                HomeScreenTile(R.drawable.other, "Other", onClick = {/*Todo*/ })
            }
        }
    }
    }
}