package com.app.dating.navigation

/*object Routes {
    var login = "Login"
    var signup = "Signup"
    var selectLanguage = "SelectLanguage"
    var walkthrough = "Walkthrough"
    var welcome = "Welcome"
    var splash = "Splash"
}*/

sealed class Routes(val route: String) {
    object LoginOTP : Routes("loginOTP")
    object LoginMobile : Routes("loginMobile")
    object Login : Routes("login")
    object Signup : Routes( "signup")
    object SelectLanguage : Routes( "selectLanguage/{previousScreen}")
    object Walkthrough : Routes("walkthrough")
    object Welcome : Routes( "welcome/")
    object Splash : Routes("splash")


//    object Home : Routes("home")
//    object Details : Routes("details/{showImage}") // Argument in the route

    fun withArgs(vararg args: Any): String {
        return route.replace("{previousScreen}", args[0].toString())
    }
}