package com.petplace.thatpetplace.homeScreen.profile.components

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileViewViewModel

@Composable
fun DisplayProfile(viewModel : ProfileViewViewModel) {
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }

    Box(
        modifier = Modifier
            .width(115.dp)

            .height(115.dp)
        , Alignment.Center
    ) {

        AsyncImage(
            model = if (selectedImage == null) {R.drawable.user_profile} else  selectedImage,
            contentDescription = "Profile photo",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .shadow(5.dp, CircleShape),
            contentScale = ContentScale.Crop
        )
    }

}