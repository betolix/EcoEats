package io.h3llo.ecoeats.domain.repository

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe

interface RecipeRepository {

    suspend fun getRecipes() : Result<List<Recipe>>
}