package com.petplace.thatpetplace.homeScreen.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAlertDialog(showBottomSheet: Boolean, onDismiss: () -> Unit, onAdd: ()->Unit,) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (showBottomSheet) {
            ModalBottomSheet(
                modifier = Modifier.height(350.dp),
                sheetState = sheetState,
                onDismissRequest = { onDismiss() }
            ) {
                Column(modifier = Modifier.padding(horizontal = 30.dp), verticalArrangement = Arrangement.SpaceAround) {

                    Text(
                        text = "Add pet detail",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Row {
                        Text(
                            text = "• ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 28.sp,
                            color = Color(0xFFF1A852)
                        )
                        Text(
                            text = "Help us take care of your pet better by completing their profile.",
                            Modifier.padding(top = 8.dp)
                        )

                    }
                    Row {
                        Text(
                            text = "• ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 28.sp,
                            color = Color(0xFFF1A852)
                        )
                        Text(
                            text = "Information about your pet helps our care providers to offer whats best for your little friends.",
                            Modifier.padding(top = 8.dp)
                        )

                    }
                    Spacer(modifier = Modifier.height(35.dp))
                    Row(Modifier.padding(bottom = 30.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        ColorToggleButton(
                            onClick = { onAdd() },
                            label = "+ Add",
                            selected = true,
                            width = 150.dp
                        )
                        ColorToggleButton(
                            onClick = {onDismiss()},
                            label = "No, Later",
                            selected = false,
                            width = 150.dp
                        )
                    }
                }

            }
        }
    }

}