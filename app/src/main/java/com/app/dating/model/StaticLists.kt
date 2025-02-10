package com.app.dating.model

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.app.dating.R

fun getOnboardingData(context: Context): List<OnboardingData> {
    return listOf(
        OnboardingData(
            R.drawable.onboarding_image_one,
            buildAnnotatedString {
                append(context.getString(R.string.meeting_new_people) + " ")
                addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, length)

                append(context.getString(R.string.in_your_area))
                addStyle(SpanStyle(color = Color(0xFF242424)), length - context.getString(R.string.in_your_area).length, length)
            }
        ),
        OnboardingData(
            R.drawable.onboarding_image_two,
            buildAnnotatedString {
                append(context.getString(R.string.meeting_new_people) + " ")
                addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, length)

                append(context.getString(R.string.in_your_area))
                addStyle(SpanStyle(color = Color(0xFF242424)), length - context.getString(R.string.in_your_area).length, length)
            }
        ),
        OnboardingData(
            R.drawable.onboarding_image_three,
            buildAnnotatedString {
                append(context.getString(R.string.meeting_new_people) + " ")
                addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, length)

                append(context.getString(R.string.in_your_area))
                addStyle(SpanStyle(color = Color(0xFF242424)), length - context.getString(R.string.in_your_area).length, length)
            }
        ),
        OnboardingData(
            R.drawable.onboarding_screen_four,
            buildAnnotatedString {
                append(context.getString(R.string.meeting_new_people) + " ")
                addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, length)

                append(context.getString(R.string.in_your_area))
                addStyle(SpanStyle(color = Color(0xFF242424)), length - context.getString(R.string.in_your_area).length, length)
            }
        ),
        OnboardingData(
            R.drawable.onboarding_screen_five,
            buildAnnotatedString {
                append(context.getString(R.string.meeting_new_people) + " ")
                addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, length)

                append(context.getString(R.string.in_your_area))
                addStyle(SpanStyle(color = Color(0xFF242424)), length - context.getString(R.string.in_your_area).length, length)
            }
        )
    )
}

val languages = listOf(
    "English" to "en",
    "Hindi" to "hi",
    "German" to "de"
)
data class OnboardingData(val image: Int, val title: AnnotatedString)
