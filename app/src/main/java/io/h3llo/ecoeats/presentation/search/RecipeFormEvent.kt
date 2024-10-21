package io.h3llo.ecoeats.presentation.search

import android.view.SearchEvent

sealed class RecipeFormEvent {

    object GetRecipes : RecipeFormEvent()
    object GetRecipesByTitle : RecipeFormEvent()
    data class TitleChange( val searchValue : String ) : RecipeFormEvent()

}