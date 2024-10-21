package io.h3llo.ecoeats.data.repository

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.FirebaseFirestore
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe
import io.h3llo.ecoeats.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

            if (task.isSuccessful) {
                val newList = task.result?.documents?.mapNotNull { document ->
                    document.toObject(Recipe::class.java)
                }
                return Result.Success(data = newList)
            } else {
                return Result.Error(message = "Error al obtener las recetas")
            }

        } catch (ex: Exception) {
            return Result.Error(message = ex.message)
        }
    }

    override suspend fun getRecipesByTitle(searchValue: String): Flow<Result<List<Recipe>>> = flow {
        try {

            val searchValueUpper = searchValue.uppercase()

            val task = firebaseFirestore
                .collection("recipes")
                .whereGreaterThanOrEqualTo("titleMayus", searchValueUpper)
                .whereLessThanOrEqualTo("titleMayus", searchValueUpper + "\uF8FF")
                .get()
            Tasks.await(task)

            if (task.isSuccessful) {
                val newList = task.result?.documents?.mapNotNull { document ->
                    document.toObject(Recipe::class.java)
                }
                // return Result.Success(data = newList)
                emit ( Result.Success(data = newList) )
            } else {
                // return Result.Error(message = "Error al obtener las recetas")
                emit ( Result.Error(message = "Error al obtener las recetas") )
            }

        } catch (ex: Exception) {
            // return Result.Error(message = ex.message)
            emit ( Result.Error(message = ex.message) )
        }
    }.flowOn(Dispatchers.IO)
}