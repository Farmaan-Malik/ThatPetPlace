package com.petplace.thatpetplace.homeScreen.profile.components


import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.homeScreen.profile.presentation.profileDetail.ProfileScreenViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream

@Composable
fun AddProfile(viewModel : ProfileScreenViewModel) {
    var selectedImage by remember {
        mutableStateOf<Uri?>(null)
    }

    val context = LocalContext.current as Activity
//photo picker
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImage = uri
            val fileDir = context.filesDir
            val file = File(fileDir, "image.png")
            //make the file
            if (uri!=null) {
                val inputStream = context.contentResolver.openInputStream(uri)
                val outputStream = FileOutputStream(file)
                inputStream!!.copyTo(outputStream)

                val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
                val image = MultipartBody.Part.createFormData("files[]", file.name, requestBody)
                viewModel.saveImage(image)
                inputStream.close()
            }
        }
    )

    fun launchPhotoPicker() {

        singlePhotoPickerLauncher.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )

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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp),
            Alignment.TopEnd
        ) {
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    launchPhotoPicker() },
                colors = IconButtonDefaults.iconButtonColors(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFFFFCB9C),
                                    Color(0xFFFDA8A5)

                                )
                            )
                        )
                        .clip(CircleShape), Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }

    }

}