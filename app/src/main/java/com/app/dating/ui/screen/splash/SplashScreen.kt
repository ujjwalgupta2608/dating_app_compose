package com.app.dating.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.dating.R
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.AbrilFatFace
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.WhiteWhisper
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    val isWalkThroughDone by viewModel.walkThroughState.collectAsState()

    LaunchedEffect(Unit) {
        delay(500) // Splash duration
        if (isWalkThroughDone){
            navController.navigate(Routes.Login.route) {
                popUpTo(Routes.Login.route) { inclusive = true } // Remove splash from backstack
            }
        }else{
            navController.navigate(Routes.SelectLanguage.withArgs("splash")) {
                popUpTo(Routes.Splash.route) { inclusive = true } // Remove splash from backstack
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Theme)
    ) {
        Image(painter = painterResource(R.drawable.shindindi_logo), contentDescription = "logo")
        Text(
            text = "Adore",
            fontFamily = AbrilFatFace,
            fontWeight = FontWeight.Bold,
            fontSize = 45.sp,
            modifier = Modifier.padding(0.dp, 13.dp, 0.dp, 0.dp),
            color = WhiteWhisper
        )
    }
}