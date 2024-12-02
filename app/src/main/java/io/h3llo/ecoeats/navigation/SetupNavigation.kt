package io.h3llo.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.h3llo.ecoeats.presentation.home.HomeScreen
import io.h3llo.ecoeats.presentation.on_boarding.OnBoardingScreen
import io.h3llo.ecoeats.presentation.sign_in.SignInScreen
import io.h3llo.ecoeats.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Welcome
        //startDestination = Screen.Welcome.route

    ) {
        //composable(route = Screen.Welcome.route) {
        composable<Welcome>{
            WelcomeScreen(
                onClick = {
                    //navController.popBackStack()
                    //navController.navigate(Screen.OnBoarding.route)
                    navController.navigate(OnBoarding)
                },
            )
        }
        //composable(route = Screen.OnBoarding.route) {
        composable<OnBoarding> {
            OnBoardingScreen(){
                navController.popBackStack()
                //navController.navigate(Screen.SignIn.route)
                navController.navigate(SignIn)
            }
        }
        //composable(route=Screen.SignIn.route){
        composable<SignIn>{
            SignInScreen(
                onNavigationHome = {
                    //navController.navigate(Screen.Home.route)
                    navController.navigate(Home)

                }
            )
        }
        //composable(route=Screen.Home.route){
        composable<Home>{
            HomeScreen()
        }

    }

}

