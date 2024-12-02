package io.h3llo.ecoeats.navigation


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Composable
fun ExampleNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        //startDestination = "screen1"
        startDestination = MyScreen1
    ){

        composable<MyScreen1>{
            Screen1(onClick = {
                navController.navigate(MyScreen2(id = 4))
            })
        }

        composable<MyScreen2> {navBackStackEntry ->
            val data = navBackStackEntry.toRoute<MyScreen2>()
            Screen2(id = data.id )

        }

        /*
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
         */
    }
}

@Serializable
object MyScreen1

@Serializable
data class MyScreen2(val id:Int)

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
