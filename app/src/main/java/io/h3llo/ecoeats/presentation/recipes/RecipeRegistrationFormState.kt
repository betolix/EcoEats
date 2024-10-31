package io.h3llo.ecoeats.presentation.recipes

import android.net.Uri
import io.h3llo.ecoeats.core.Result

data class RecipeRegistrationFormState(
    val title:String="",
    val titleError:String?=null,
    val description:String="",
    val descriptionError:String?=null,
    val uri: Uri?=null
)
