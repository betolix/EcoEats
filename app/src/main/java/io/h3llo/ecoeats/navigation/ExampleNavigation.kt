package io.h3llo.ecoeats.navigation


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun ExampleNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "screen1"
    ){

        composable(route = "screen1") {
            Screen1(onClick = {
                navController.navigate("screen2/${2}")

            })
        }

        composable(
            route = "screen2/{id}",
            arguments = listOf(navArgument("id"){ type = NavType.IntType})
        ) {
            val id = requireNotNull(it.arguments?.getInt("id"))
            Screen2(id = id)
        }


    }

}


@Composable
fun Screen1 ( onClick:()-> Unit ){

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = { onClick() }){
            Text(text = "Next")
        }
    }
}

@Composable
fun Screen2 ( id:Int ){

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Text(text = "$id")
    }
}
