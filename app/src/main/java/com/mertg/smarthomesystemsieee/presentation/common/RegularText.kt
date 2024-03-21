package com.mertg.smarthomesystemsieee.presentation.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mertg.smarthomesystemsieee.R

@Composable
fun RegularText(
    text: String,
    fontSize: Float,
    color: Color
){
    Text(text = text,
        fontSize = fontSize.sp,
        fontFamily = FontFamily(Font(R.font.poppins)),
        fontWeight = FontWeight.Normal,
        color = color
    )
}