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
        startDestination = Screen.Welcome.route
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                onClick = {
                    //navController.popBackStack()
                    navController.navigate(Screen.OnBoarding.route)
                },
            )
        }
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(){
                navController.popBackStack()
                navController.navigate(Screen.SignIn.route)
            }
        }
        composable(route=Screen.SignIn.route){
            SignInScreen()
        }
    }

}

