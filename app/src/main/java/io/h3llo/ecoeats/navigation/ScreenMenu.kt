package io.h3llo.ecoeats.navigation

sealed class ScreenMenu (val route:String){

    object Dishes : ScreenMenu(route = "dishes_screen")
    object Search : ScreenMenu(route = "search_screen")
    object Settings : ScreenMenu(route = "settings_screen")
    object Detail : ScreenMenu(route = "detail_screen/?dishJson={dishJson}"){
        fun createRoute(dishJson:String) = "detail_screen/?dishJson=$dishJson"
    }
}