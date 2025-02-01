package com.app.dating.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.dating.R

// Set of Material typography styles to start with
val AbrilFatFace = FontFamily(
    Font(R.font.abril_fatface_regular,  FontWeight.Bold)
)
val Inter = FontFamily(
    Font(R.font.inter_regular,  FontWeight.Normal),
    Font(R.font.inter_bold,  FontWeight.Bold),
    Font(R.font.inter_semi_bold,  FontWeight.SemiBold),
    Font(R.font.inter_medium,  FontWeight.Medium),
    Font(R.font.inter_extra_light,  FontWeight.ExtraLight),
    Font(R.font.inter_extra_bold,  FontWeight.ExtraBold),
    Font(R.font.inter_light,  FontWeight.Light),
    Font(R.font.inter_thin,  FontWeight.Thin),
    Font(R.font.inter_black,  FontWeight.Black),
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 17.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = BlackMineShaft
    ),
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
)