package com.app.dating.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dating.R
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.BlackMineShaft
import com.app.dating.ui.theme.GreyBoulder
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.Typography
import com.app.dating.ui.theme.WhiteWhisper


@Preview
@Composable
fun WelcomeScreen(navController: NavHostController) {
    // Use a scrollable column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // Make the column scrollable
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(0.6f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.padding(top = 70.dp)) {
                Image(
                    painter = painterResource(R.drawable.dating_image),
                    contentDescription = "Welcome Image"
                )
                Text(
                    text = "Adore",
                    color = BlackMineShaft,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 40.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.welcome_background_image),
                contentDescription = "Welcome Image",
                modifier = Modifier.padding(20.dp)
            )
        }

        Column(modifier = Modifier.weight(0.4f)) {
            Text(
                text = buildAnnotatedString {
                    append("Discover Love: ")
                    addStyle(SpanStyle(color = Color(0xFF6D53F4)), 0, 14)

                    append("Where Your Story Begins.")
                    addStyle(SpanStyle(color = Color(0xFF242424)), 14, length)
                },
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(horizontal = 53.dp),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier.clickable {
                    navController.navigate(Routes.Walkthrough.route)
                }
                    .padding(24.dp, 70.dp, 24.dp, 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Theme)
                    .padding(horizontal = 13.dp, vertical = 13.dp)
            ) {
                Text(
                    text = "Let’s Get Started",
                    style = Typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Row(
                modifier = Modifier
                    .padding(24.dp, 25.dp, 24.dp, 24.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Already have an account?",
                    color = GreyBoulder,
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Login",
                    color = Theme,
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .clickable {
                            navController.navigate(Routes.Login.route)
                        },
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

