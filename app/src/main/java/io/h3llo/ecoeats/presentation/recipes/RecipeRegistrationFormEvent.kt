package io.h3llo.ecoeats.presentation.recipes

import android.net.Uri

sealed class RecipeRegistrationFormEvent {

    data class TitleChange(val title: String) : RecipeRegistrationFormEvent()
    data class DescriptionChange(val description: String) : RecipeRegistrationFormEvent()
    data class ImageChange(val uri: Uri) : RecipeRegistrationFormEvent()
    object Submit : RecipeRegistrationFormEvent()
}