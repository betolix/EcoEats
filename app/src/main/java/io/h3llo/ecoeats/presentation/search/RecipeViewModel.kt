package io.h3llo.ecoeats.presentation.search


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.use_cases.get_recipes.GetRecipesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    val getRecipesUseCase: GetRecipesUseCase
) : ViewModel() {

    var state by mutableStateOf(RecipeScreenState())
    private set

    fun onEvent( onEvent: RecipeFormEvent ){
        when(onEvent) {
            RecipeFormEvent.GetRecipes -> {
                getRecipes()
            }
        }
    }

    private fun getRecipes(){

        viewModelScope.launch{
            state = state.copy(isLoading = true)
            val response = withContext(Dispatchers.IO ){
                getRecipesUseCase()
            }
            when(response) {
                is Result.Error -> {
                    state = state.copy (error = response.message, isLoading = false)
                }
                is Result.Success -> {
                    state = state. copy (success = response.data, isLoading = false)
                }
                is Result.Validation -> TODO()
            }
        }
    }


}