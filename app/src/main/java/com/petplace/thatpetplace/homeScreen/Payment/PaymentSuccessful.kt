package com.petplace.thatpetplace.homeScreen.Payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes

@Composable
fun PaymentSuccessful(navHostController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0xFFFDA8A5),
                    Color(0xFFFFCB9C),
                )
            )
        ),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally){
        Box (modifier = Modifier
            .width(150.dp)
            .padding(top = 80.dp)
            .height(150.dp)
            .clip(CircleShape)
            .background(Color.White),
            contentAlignment = Alignment.Center

        ){
            Icon(imageVector  = Icons.Default.Check,
                contentDescription = "done",
                modifier = Modifier.size(80.dp),
                tint =  Color(0xFFFDA8A5)
            )


        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Your appointment\n" +
                "has been booked",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,

        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Vasilenko Oksana will be waiting for you and your pet",
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 10.dp)


            )
        Box (modifier = Modifier
            .width(280.dp)
            .padding(top = 80.dp)
            .height(60.dp)
            .clip(CircleShape)
            .background(Color.Black),
            contentAlignment = Alignment.Center

        ){
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){


            Icon(painter = painterResource(id = R.drawable.clock_outlined),
                contentDescription = "done",
                modifier = Modifier.size(80.dp),
                tint =  Color(0xFFFDA8A5)
            )
                Text(text = "Wed 9 Sep at 10:30 am",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,)

            }



        }
Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier
            .width(280.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(80))
            .border(5.dp, color = Color.White, shape = RoundedCornerShape(45)),
            onClick = { navHostController.navigate(Routes.HomeScreenRoutes.APPOINTMENT_SCREEN)} ,
            elevation = ButtonDefaults.elevation(0.dp),
            colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Transparent))
        {
            Text(text = "Go to My appointment",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,



                )
        }



    }

}

