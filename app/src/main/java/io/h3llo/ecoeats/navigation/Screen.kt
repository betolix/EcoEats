package io.h3llo.ecoeats.navigation

sealed class Screen(val route:String ) {

    object Welcome : Screen (route = "welcome_screen")
    object OnBoarding : Screen (route = "on_boarding_screen")
    object SignIn : Screen (route = "sign_in_screen")

}