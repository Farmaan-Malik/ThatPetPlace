package com.petplace.thatpetplace.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun LoadingDialogBox() {
    AlertDialog(onDismissRequest = { /*TODO*/ },
        confirmButton = { /*TODO*/ },
        properties = DialogProperties(
            dismissOnClickOutside = false, dismissOnBackPress = false
        ), text = {
            Box(modifier = Modifier.background(Color.Transparent).height(150.dp).width(150.dp), contentAlignment = Alignment.Center) {
                AnimationLoader(modifier = Modifier.height(150.dp).width(150.dp)

                )
            }


        }
    , backgroundColor = Color(0xFFFDA8A5),
        modifier = Modifier.clip(CircleShape).height(150.dp).width(150.dp)
            )
}
