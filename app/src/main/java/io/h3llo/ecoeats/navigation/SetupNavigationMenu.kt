package io.h3llo.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.h3llo.ecoeats.presentation.dishes.DishesScreen
import io.h3llo.ecoeats.presentation.search.SearchScreen
import io.h3llo.ecoeats.presentation.settings.SettingsScreen


@Composable
fun SetupNavigationMenu(navController: NavHostController) {

    // INVOCAR AL GRAFO
    NavHost(
        navController = navController,
        startDestination = ScreenMenu.Dishes.route
    ){
        composable (route = ScreenMenu.Dishes.route){
            DishesScreen()
        }
        composable (route = ScreenMenu.Search.route){
            SearchScreen()
        }
        composable (route = ScreenMenu.Settings.route){
            SettingsScreen()
        }
        composable (route = ScreenMenu.Detail.route){
            //DishesScreen()
        }


    }
    
}

