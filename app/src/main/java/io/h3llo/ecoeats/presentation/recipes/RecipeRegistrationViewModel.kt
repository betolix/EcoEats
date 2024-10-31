package io.h3llo.ecoeats.presentation.recipes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeRegistrationViewModel : ViewModel() {

    private var _state = MutableStateFlow(RecipeRegistrationScreenState())
    val state : StateFlow<RecipeRegistrationScreenState> = _state.asStateFlow()

    private var _formState = MutableStateFlow(RecipeRegistrationFormState())
    val formState : StateFlow<RecipeRegistrationFormState> = _formState.asStateFlow()

    fun onEvent( event: RecipeRegistrationFormEvent){
        when(event){
            is RecipeRegistrationFormEvent.DescriptionChange -> {
                _formState.update { it.copy(description = event.description) }
            }
            is RecipeRegistrationFormEvent.ImageChange -> {
                _formState.update { it.copy(uri = event.uri) }
            }
            RecipeRegistrationFormEvent.Submit -> {
                saveRecipe()
            }
            is RecipeRegistrationFormEvent.TitleChange -> {
                _formState.update { it.copy(title = event.title) }
            }
        }
    }

    private fun saveRecipe() {
        TODO("Not yet implemented")
    }


}