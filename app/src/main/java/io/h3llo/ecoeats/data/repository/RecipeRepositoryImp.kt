package io.h3llo.ecoeats.data.repository

import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.FirebaseFirestore
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe
import io.h3llo.ecoeats.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImp @Inject constructor(
    val firebaseFirestore: FirebaseFirestore
) : RecipeRepository {
    override suspend fun getRecipes(): Result<List<Recipe>> {

        try {

            val task = firebaseFirestore
                .collection("recipes")
                .get()
            Tasks.await(task)

            if(task.isSuccessful){
                val newList = task.result?.documents?.mapNotNull { document ->
                    document.toObject(Recipe::class.java)
                }
                return Result.Success(data = newList)
            }else{
                return Result.Error(message = "Error al obtener las recetas")
            }

        } catch (ex: Exception) {
            return Result.Error(message = ex.message)
        }
    }
}