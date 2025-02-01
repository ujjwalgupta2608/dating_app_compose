package com.app.dating.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.dating.ui.screen.LoginScreen
import com.app.dating.ui.screen.SelectLanguageScreen
import com.app.dating.ui.screen.SignUpScreen
import com.app.dating.ui.screen.SplashScreen
import com.app.dating.ui.screen.WalkthroughScreen
import com.app.dating.ui.screen.WelcomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.splash){
        composable(Routes.splash){
            SplashScreen(navController)
        }
        composable(Routes.welcome){
            WelcomeScreen(navController)
        }
        composable(Routes.login){
            LoginScreen(navController)
        }
        composable(Routes.signup){
            SignUpScreen(navController)
        }
        composable(Routes.selectLanguage){
            SelectLanguageScreen(navController)
        }
        composable(Routes.walkthrough){
            WalkthroughScreen()
        }
    }
}