package io.h3llo.ecoeats.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.google.gson.Gson
import io.h3llo.ecoeats.domain.model.Dish
import io.h3llo.ecoeats.presentation.detail.DetailScreen
import io.h3llo.ecoeats.presentation.dishes.DishesScreen
import io.h3llo.ecoeats.presentation.recipes.RecipeRegistrationScreen
import io.h3llo.ecoeats.presentation.search.RecipeScreen
import io.h3llo.ecoeats.presentation.settings.SettingsScreen


@Composable
fun SetupNavigationMenu(
    navController: NavHostController,
    paddingValues: PaddingValues,
    onChangeVisibleBottomBar: (Boolean)-> Unit
) {

    // INVOCAR AL GRAFO
    NavHost(
        navController = navController,
        startDestination = Dishes
    ){
        composable<Dishes>{
            onChangeVisibleBottomBar(true)
            DishesScreen(
                paddingValues = paddingValues,
                onClick ={
                    val dishJson = Gson().toJson(it)
                    //navController.navigate("detail_screen/?dishJson=$dishJson")
                    //navController.navigate(ScreenMenu.Detail.createRoute(dishJson))
                    navController.navigate(Detail(dishJson = dishJson))
                }
            )
        }
        composable<Search>{
            onChangeVisibleBottomBar(true)
            RecipeScreen( paddingValues = paddingValues )
        }
        composable<Settings>{
            onChangeVisibleBottomBar(true)
            //SettingsScreen( paddingValues = paddingValues )
            RecipeRegistrationScreen( paddingValues = paddingValues)
        }
        composable<Detail>{
            onChangeVisibleBottomBar(false)
            // val dishJson = it.arguments?.getString("dishJson")
            val data = it.toRoute<Detail>()
            val dish = Gson().fromJson(data.dishJson, Dish::class.java)
            requireNotNull(dish)
            DetailScreen(dish = dish, paddingValues = paddingValues)
        }
//        composable(route = ScreenMenu.RecipeRegistrationScreen.route){
//            RecipeRegistrationScreen( paddingValues = paddingValues)
//        }


    }
    
}

