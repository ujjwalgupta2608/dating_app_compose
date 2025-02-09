package com.app.dating.ui.screen.walkthrough

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dating.R
import com.app.dating.model.OnboardingData
import com.app.dating.model.onboardingData
import androidx.compose.ui.text.buildAnnotatedString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.Inter
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.UnselectedDot
import kotlinx.coroutines.launch

@Preview
@Composable
fun WalkthroughScreen(navController: NavHostController, viewModel: WalkthroughViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { onboardingData.size }
    )

    val coroutineScope = rememberCoroutineScope() // CoroutineScope for launching suspend functions
    val highlightPreviousButton = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // HorizontalPager taking 75% of the screen height
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f),
            userScrollEnabled = false// Pager takes 75% of the screen height
        ) { page ->
            highlightPreviousButton.value = page!=0
            PagerDesign(onboardingData[page])
        }

        // Indicator + Buttons Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f) // Bottom section takes remaining 25%
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Previous Button
            Button(
                onClick = {
                    coroutineScope.launch {
                        previousButtonClick(pagerState)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                contentPadding = PaddingValues(0.dp) // Remove default padding
            ) {
                Image(
                    painter = painterResource(
                        if (highlightPreviousButton.value) R.drawable.previous_selected
                        else R.drawable.previous_unselected
                    ),
                    contentDescription = null
                )
            }

            // Indicator in the center
            CustomPagerIndicator(currentPage = pagerState.currentPage, pageCount = onboardingData.size)

            // Next Button
            Button(
                onClick = {
                    coroutineScope.launch {
                        nextButtonClick(pagerState, navController, viewModel)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                contentPadding = PaddingValues(0.dp) // Remove default padding
            ) {
                Image(
                    painter = painterResource(R.drawable.next_button),
                    contentDescription = null
                )
            }
        }
    }
}

// Function to handle previous button click
suspend fun previousButtonClick(pagerState: PagerState) {
    if (pagerState.currentPage > 0) {
        pagerState.animateScrollToPage(pagerState.currentPage - 1)
    }
}

// Function to handle next button click
suspend fun nextButtonClick(
    pagerState: PagerState,
    navController: NavHostController,
    viewModel: WalkthroughViewModel
) {
    if (pagerState.currentPage < pagerState.pageCount - 1) {
        pagerState.animateScrollToPage(pagerState.currentPage + 1)
    }else{
        viewModel.setWalkThrough(true)
        navController.navigate(Routes.Login.route)
    }
}



@Composable
fun PagerDesign(onboardingData: OnboardingData) {
    Column {
        Image(
            painter = painterResource(onboardingData.image ?: R.drawable.shindindi_logo),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.80f)
                .offset(y = (-15).dp),
            contentDescription = null
        )
        Text(
            text = onboardingData.title ?: buildAnnotatedString { },
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .weight(0.25f)
                .offset(y = (-15).dp)
                .padding(top = 33.dp, start = 35.dp, end = 35.dp)
        )
    }
}

@Composable
fun CustomPagerIndicator(currentPage: Int, pageCount: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        repeat(pageCount) { index ->
            Box(
                modifier = Modifier
                    .padding(3.dp)
                    .size(if (index == currentPage) 10.dp else 6.dp) // Active dot is bigger
                    .clip(CircleShape)
                    .background(if (index == currentPage) Theme else UnselectedDot)

            )
        }
    }
}
