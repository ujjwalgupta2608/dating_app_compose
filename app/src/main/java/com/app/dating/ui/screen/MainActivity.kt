package com.app.dating.ui.screen

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.dating.R
import com.app.dating.navigation.AppNavigation
import com.app.dating.navigation.Routes
import com.app.dating.ui.theme.AbrilFatFace
import com.app.dating.ui.theme.Theme
import com.app.dating.ui.theme.WhiteWhisper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}
fun Context.getActivity(): MainActivity? = when (this) {
    is MainActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(500) // Splash duration
        navController.navigate(Routes.SelectLanguage.withArgs("splash")) {
            popUpTo(Routes.Splash.route) { inclusive = true } // Remove splash from backstack
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
