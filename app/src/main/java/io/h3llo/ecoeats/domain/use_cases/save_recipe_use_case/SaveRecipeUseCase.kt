package io.h3llo.ecoeats.domain.use_cases.save_recipe_use_case

import android.net.Uri
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveRecipeUseCase @Inject constructor(
    val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke(title: String, description:String, uri: Uri?) : Flow<Result<String>>{

        return recipeRepository.uploadImageAndSaveRecipe(title, description, uri)

    }
}