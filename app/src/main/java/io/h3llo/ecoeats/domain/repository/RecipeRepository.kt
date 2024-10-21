package io.h3llo.ecoeats.domain.repository

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipes() : Result<List<Recipe>>

    suspend fun getRecipesByTitle(searchValue : String ) : Flow<Result<List<Recipe>>>


}