package io.h3llo.ecoeats.presentation.recipes

import android.net.Uri

data class RecipeRegistrationScreenState(
    val title:String="",
    val titleError:String?=null,
    val description:String="",
    val descriptionError:String?=null,
    val uri: Uri?=null

)
