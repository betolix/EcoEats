package io.h3llo.ecoeats.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import io.h3llo.ecoeats.data.networking.model.DishDto
import io.h3llo.ecoeats.presentation.detail.DetailScreen
import io.h3llo.ecoeats.presentation.dishes.DishesScreen
import io.h3llo.ecoeats.presentation.search.SearchScreen
import io.h3llo.ecoeats.presentation.settings.SettingsScreen


@Composable
fun SetupNavigationMenu(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    // INVOCAR AL GRAFO
    NavHost(
        navController = navController,
        startDestination = ScreenMenu.Dishes.route
    ){
        composable (route = ScreenMenu.Dishes.route){
            DishesScreen(
                paddingValues = paddingValues,
                onClick ={
                    val dishJson = Gson().toJson(it)
                    //navController.navigate("detail_screen/?dishJson=$dishJson")
                    navController.navigate(ScreenMenu.Detail.createRoute(dishJson))
                }
            )
        }
        composable (route = ScreenMenu.Search.route){
            SearchScreen( paddingValues = paddingValues)
        }
        composable (route = ScreenMenu.Settings.route){
            SettingsScreen( paddingValues = paddingValues)
        }
        composable (route = ScreenMenu.Detail.route){
            val dishJson = it.arguments?.getString("dishJson")
            val dishDto = Gson().fromJson(dishJson, DishDto::class.java)
            requireNotNull(dishDto)
            DetailScreen(dishDto = dishDto)
        }


    }
    
}

