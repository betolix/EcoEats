package io.h3llo.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.h3llo.ecoeats.presentation.on_boarding.OnBoardingScreen
import io.h3llo.ecoeats.presentation.sign_in.SignInScreen
import io.h3llo.ecoeats.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome_screen"
    ) {
        composable(route = "welcome_screen") {
            WelcomeScreen(
                onClick = {
                    //navController.popBackStack()
                    navController.navigate("onboarding_screen")
                },
            )
        }
        composable(route = "onboarding_screen") {
            OnBoardingScreen(){
                navController.popBackStack()
                navController.navigate("sign_in_screen")
            }
        }
        composable(route="sign_in_screen"){
            SignInScreen()
        }
    }

}

