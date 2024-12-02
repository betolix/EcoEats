package io.h3llo.ecoeats.navigation

import kotlinx.serialization.Serializable

/*
sealed class Screen(val route:String ) {

    object Welcome : Screen (route = "welcome_screen")
    object OnBoarding : Screen (route = "on_boarding_screen")
    object SignIn : Screen (route = "sign_in_screen")
    object Home : Screen(route = "home_screen")

}
 */

@Serializable
object Welcome
@Serializable
object OnBoarding
@Serializable
object SignIn
@Serializable
object Home