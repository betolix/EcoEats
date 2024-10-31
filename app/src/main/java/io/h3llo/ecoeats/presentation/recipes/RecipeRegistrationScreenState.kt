package io.h3llo.ecoeats.presentation.recipes

import android.net.Uri

data class RecipeRegistrationScreenState(

    val success: Unit?=null,
    val error : String?=null,
    val isLoading:Boolean=false

)
