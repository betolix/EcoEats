package io.h3llo.ecoeats.domain.use_cases.get_recipes

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe
import io.h3llo.ecoeats.domain.repository.RecipeRepository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke() : Result<List<Recipe>>{
        return recipeRepository.getRecipes()
    }

}