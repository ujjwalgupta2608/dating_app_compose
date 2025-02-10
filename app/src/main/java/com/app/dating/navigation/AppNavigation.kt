package com.app.dating.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.dating.ui.screen.login.LoginFlow
import com.app.dating.ui.screen.LoginWithMobileFlow
import com.app.dating.ui.screen.language.SelectLanguageScreen
import com.app.dating.ui.screen.SignUpScreen
import com.app.dating.ui.screen.walkthrough.WalkthroughScreen
import com.app.dating.ui.screen.WelcomeScreen
import com.app.dating.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Splash.route){
        composable(Routes.Splash.route){
            SplashScreen(navController)
        }
        composable(Routes.Welcome.route){
            WelcomeScreen(navController)
        }
        composable(Routes.Login.route){
            LoginFlow(navController)
        }
        composable(Routes.Signup.route){
            SignUpScreen(navController)
        }
        composable(Routes.SelectLanguage.route){ backStackEntry ->
            val previousScreen = backStackEntry.arguments?.getString("previousScreen") ?: ""
            SelectLanguageScreen(navController,  previousScreen)
        }
        composable(Routes.Walkthrough.route){
            WalkthroughScreen(navController)
        }
        composable(Routes.LoginMobile.route){
            LoginWithMobileFlow(navController)
        }
        composable(Routes.LoginOTP.route){
//            LoginOTPScreen()
        }
    }
}