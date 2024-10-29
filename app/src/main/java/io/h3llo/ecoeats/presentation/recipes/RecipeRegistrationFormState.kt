package io.h3llo.ecoeats.presentation.recipes

import io.h3llo.ecoeats.core.Result

data class RecipeRegistrationFormState(
    val success: Unit?=null,
    val error : String?=null,
    val isLoading:Boolean=false
)
