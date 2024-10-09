package io.h3llo.ecoeats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import io.h3llo.ecoeats.navigation.SetupNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()

        // val preferences = getSharedPreferences("PREFERENCES_TEST",0).edit()
        // preferences.putString("KEY", "123")
        // preferences.apply()


        val firestore = FirebaseFirestore.getInstance()
        firestore
            .collection("recipes")
            //.document()
            .get()
            .addOnSuccessListener {recipes ->

                val newList = recipes.documents.mapNotNull {document ->
                    document.toObject(Recipe::class.java)
                }

                newList.forEach{recipe ->
                    println("${recipe.title} ${recipe.description}")
                }

            }.addOnFailureListener {
                println(it.message)
            }


        setContent {
            SetupNavigation()
        }
    }
}

data class Recipe(
    val title: String = "",
    val description : String = "",
    val url : String = ""
)

