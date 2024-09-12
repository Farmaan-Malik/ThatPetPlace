package com.petplace.thatpetplace.homeScreen.profile.components


import android.app.Activity
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail.PetDetailViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.FileOutputStream

// composable for bottom sheet photo picker
@Composable
fun PhotoPicker(viewModel: PetDetailViewModel) {
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        if (selectedImage==null){
            //select photo button
            IconButton(
                modifier = Modifier.fillMaxSize(.50f),
                onClick = {
                    launchPhotoPicker()

                }) {
                Box(
                    modifier =  Modifier
                        .fillMaxWidth().height(70.dp)

                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)

                        ),
                    contentAlignment = Alignment.Center

                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "",
                            tint =Color.Green
                        )
                        Text(text = "Add Image", color =Color.Black)
                    }
                }
            }
        }
        else{ //preview of image selected
            ImageLayoutView(selectedImage = selectedImage)
            IconButton(
                modifier = Modifier.fillMaxWidth(.50f),
                onClick = {

                    selectedImage = null
                    viewModel.removeImage()

                }) {
                Box{
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically){


                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "",
                            tint = Color.Green
                        )

                    }
                }
            }
        }
    }



}


@Composable
fun ImageLayoutView(selectedImage: Uri?) {
    //selected image
    Box(modifier = Modifier
        .width(300.dp)
        .height(200.dp)
        .padding(2.dp)
        .border(5.dp, Color.Black)
        .background(Color.LightGray),


        ) {


        AsyncImage(
            model = selectedImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
            ,
            contentScale = ContentScale.FillWidth
        )

    }
}