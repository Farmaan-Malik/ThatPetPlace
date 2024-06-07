package com.petplace.thatpetplace.welcome.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int ) {
    Row(
        modifier = Modifier
            .padding(horizontal = 48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        repeat(pageCount) {
            IndicatorLines(
                isSelected = it == currentPage
            )
        }

    }
}

@Composable
fun IndicatorLines(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 22.dp else 8.dp, label = "")
    val height = animateDpAsState(targetValue = if (isSelected) 8.dp else 8.dp, label = "")
    Box(modifier= Modifier
        .padding(horizontal = 4.dp)
        .width(width.value)
        .height(height.value)

        .clip(CircleShape)
        .background(if (isSelected) Color(0xFFF1A852) else Color(0xFFE6E7F8)))
}