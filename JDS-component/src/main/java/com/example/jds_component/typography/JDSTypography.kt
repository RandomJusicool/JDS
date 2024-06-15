package com.example.jds_component.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.jds_component.R

val pretendard = FontFamily(
    Font(R.font.pretendard),
    Font(R.font.pretendard_regular),
    Font(R.font.pretendard_semi_bold)
)

val JDSTypography = Typography(
    labelSmall = TextStyle( // Sub Title
        fontSize = 18.sp,
        fontFamily = pretendard,
        lineHeight = 27.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
    ),
    titleLarge = TextStyle(
        fontSize = 48.sp,
        fontFamily = pretendard,
        lineHeight = 58.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    ),
    titleMedium = TextStyle(
        fontSize = 36.sp,
        fontFamily = pretendard,
        lineHeight = 43.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
    ),
    titleSmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = pretendard,
        lineHeight = 31.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = pretendard,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = pretendard,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = pretendard,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
    ),
    labelLarge = TextStyle( //lable
        fontSize = 12.sp,
        fontFamily = pretendard,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
    )
)