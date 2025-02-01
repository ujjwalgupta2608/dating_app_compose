package com.app.dating.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.app.dating.R

val onboardingData = listOf(
    OnboardingData(R.drawable.onboarding_image_one, buildAnnotatedString {
        append("Meeting New People ")
        addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, 19)

        append("in Your Area")
        addStyle(SpanStyle(color = Color(0xFF242424)), 19, length)
    }),
    OnboardingData(R.drawable.onboarding_image_two, buildAnnotatedString {
        append("Two")
        addStyle(SpanStyle(color = Color(0xFF242424)), 0, length)
    }),
    OnboardingData(R.drawable.onboarding_image_three, buildAnnotatedString {
        append("Three")
        addStyle(SpanStyle(color = Color(0xFF242424)), 0, length)
    }),
    OnboardingData(R.drawable.onboarding_screen_four, buildAnnotatedString {
        append("Four")
        addStyle(SpanStyle(color = Color(0xFF242424)), 0, length)
    }),
    OnboardingData(R.drawable.onboarding_screen_five, buildAnnotatedString {
        append("Five")
        addStyle(SpanStyle(color = Color(0xFF242424)), 0, length)
    })
)

data class OnboardingData(val image: Int? = null, val title: AnnotatedString? = null)