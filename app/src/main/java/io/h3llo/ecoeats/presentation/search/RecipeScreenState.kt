package io.h3llo.ecoeats.presentation.search

import io.h3llo.ecoeats.domain.model.Recipe

// data class RecipeScreenState()

data class RecipeScreenState(
    val success: List<Recipe>?=null,
    val error: String?=null,
    val isLoading:Boolean=false
)