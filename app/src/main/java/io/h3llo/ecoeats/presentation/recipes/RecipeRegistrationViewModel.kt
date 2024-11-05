package io.h3llo.ecoeats.presentation.recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.use_cases.save_recipe_use_case.SaveRecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeRegistrationViewModel @Inject constructor(
    val saveRecipeUseCase: SaveRecipeUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(RecipeRegistrationScreenState())
    val state: StateFlow<RecipeRegistrationScreenState> = _state.asStateFlow()

    private var _formState = MutableStateFlow(RecipeRegistrationFormState())
    val formState: StateFlow<RecipeRegistrationFormState> = _formState.asStateFlow()

    fun onEvent(event: RecipeRegistrationFormEvent) {
        when (event) {
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

        viewModelScope.launch {

            _state.update { it.copy(isLoading = true) }

            val title = formState.map { it.title }.first() // .first() or toString
            val description = formState.map { it.description }.first()
            val uri = formState.map { it.uri }.first()

            saveRecipeUseCase(title, description, uri).onEach { result ->
                when(result){
                    is Result.Error -> {
                        _state.update {it.copy(error = result.message, isLoading = false )}
                    }
                    is Result.Success -> {
                        _state.update { it.copy(success = result.data, isLoading = false )}
                    }
                    is Result.Validation -> TODO()
                }

            }.launchIn(viewModelScope)
        }
    }


}