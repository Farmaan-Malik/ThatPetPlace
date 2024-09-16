package com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.explore.components.ExploreClinicsCard
import com.petplace.thatpetplace.homeScreen.explore.components.ExploreDetailCard
import com.petplace.thatpetplace.homeScreen.explore.components.TopBarExplore
import com.petplace.thatpetplace.homeScreen.profile.components.ColorToggleButton
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreDetailScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: ExploreDetailScreenViewModel = koinViewModel(),
    isProfile: () -> Unit
) {
    LaunchedEffect(Unit) {
        isProfile()
    }
    DisposableEffect(Unit) {
        onDispose { isProfile() }
    }
    Scaffold(topBar = {
        TopBarExplore(navController = navController)
    }) {
        it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.pet_profile),
                    contentDescription = "Profile photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF7993D7),
                                Color.White,
                                Color.Transparent,
                                Color.Transparent
                            ),
                            startY = size.height / 5,
                            endY = size.height
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    })
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
            ) {
                ExploreDetailCard(offsetX = 0.dp, offsetY = (-70).dp)
                Text(
                    text = "\"" + "Where your pet's needs come first." + "\"",
                    fontSize = 20.sp,
                    color = Color(0xFFBBC3CE),
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.offset(x = 0.dp, y = (-30).dp)
                )
                Text(text = "About us:", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Welcome to Little Paws, your one-stop destination for everything your beloved pets need! At Little Paws, we’re passionate about animals and committed to providing top-quality products, expert advice, and personalized care to pet owners like you. With years of experience in the pet industry, we understand that pets are more than just animals—they're family. That’s why we offer a wide range of premium pet foods, toys, accessories, and grooming supplies, carefully selected to meet the unique needs of every pet, whether they’re furry, feathered, or scaly. Visit us today and let us help you give your pets the love and care they deserve!",
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )
                Text(
                    text = "Available doctors: ",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )

            }
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(5) {
                    ExploreClinicsCard(onClick = {})
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 8.dp)
                    .clip(
                        RoundedCornerShape(topEndPercent = 30, topStartPercent = 30)
                    )
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(.5f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "$20", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = "/first visit", fontSize = 16.sp)
                }
                ColorToggleButton(onClick = { /*TODO*/ }, label = "Book", selected = true)
            }


        }


    }

}