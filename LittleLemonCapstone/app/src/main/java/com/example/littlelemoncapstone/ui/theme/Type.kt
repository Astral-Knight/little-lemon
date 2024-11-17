package com.example.littlelemoncapstone.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemoncapstone.R

val karla = FontFamily(Font(R.font.karla_regular))
val markazi = FontFamily(Font(R.font.markazi_text_regular))

val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = karla ,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),

    titleLarge = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),

    titleMedium = TextStyle(
        fontFamily = markazi,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),

    labelLarge = TextStyle(
        fontFamily = karla,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
