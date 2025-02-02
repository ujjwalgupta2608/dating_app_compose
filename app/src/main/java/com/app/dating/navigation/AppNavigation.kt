package com.app.dating.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.dating.ui.screen.LoginFlow
import com.app.dating.ui.screen.SelectLanguageScreen
import com.app.dating.ui.screen.SignUpScreen
import com.app.dating.ui.screen.SplashScreen
import com.app.dating.ui.screen.WalkthroughScreen
import com.app.dating.ui.screen.WelcomeScreen

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
    }
}