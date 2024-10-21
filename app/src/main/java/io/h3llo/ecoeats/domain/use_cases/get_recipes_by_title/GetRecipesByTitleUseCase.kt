package io.h3llo.ecoeats.domain.use_cases.get_recipes_by_title

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.Recipe
import io.h3llo.ecoeats.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesByTitleUseCase @Inject constructor(
    val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke(searchValue : String): Flow<Result<List<Recipe>>> {
        return recipeRepository.getRecipesByTitle(searchValue)
    }
}