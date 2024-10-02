package com.petplace.thatpetplace.homeScreen.profile.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileViewViewModel

@Composable
fun DisplayPet(viewModel: ProfileViewViewModel, navController: NavHostController, petName: String) {
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxHeight(.35f)
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(15)),
        shape = RoundedCornerShape(bottomEndPercent = 15, bottomStartPercent = 15),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .height(50.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { navController.navigate(Routes.HomeScreenRoutes.PET_PROFILE_SCREEN) },
                    modifier = Modifier.width(80.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = "Edit",
                        tint = Color(0xFFFDA8A5)
                    )
                    Text(
                        text = "Edit",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp),
                        textAlign = TextAlign.End,
                        fontSize = 12.sp,
                        color = Color(0xFFFDA8A5)
                    )
                }
            }
            AsyncImage(
                model = if (selectedImage == null) {
                    R.drawable.petprofile_placeholder
                } else selectedImage,
                contentDescription = "Profile photo",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .padding(8.dp)
                    .clip(
                        CircleShape
                    )
                    .shadow(8.dp, CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = petName,
                fontSize = 16.sp,
                textAlign = TextAlign.End,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp, bottom = 20.dp)
            )
        }
    }
}