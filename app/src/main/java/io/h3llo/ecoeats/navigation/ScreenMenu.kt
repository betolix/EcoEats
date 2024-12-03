package io.h3llo.ecoeats.navigation

import kotlinx.serialization.Serializable

/*
sealed class ScreenMenu (val route:String){

    object Dishes : ScreenMenu(route = "dishes_screen")
    object Search : ScreenMenu(route = "search_screen")
    object Settings : ScreenMenu(route = "settings_screen")
    object Detail : ScreenMenu(route = "detail_screen/?dishJson={dishJson}"){
        fun createRoute(dishJson:String) = "detail_screen/?dishJson=$dishJson"
    }
    //object RecipeRegistrationScreen : ScreenMenu(route = "recipes_register")
}
*/

@Serializable
object Dishes

@Serializable
object Search

@Serializable
object Settings

@Serializable
data class Detail (val dishJson:String)