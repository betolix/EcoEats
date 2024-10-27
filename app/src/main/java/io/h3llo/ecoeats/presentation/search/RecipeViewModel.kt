package io.h3llo.ecoeats.presentation.search


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.use_cases.get_recipes.GetRecipesUseCase
import io.h3llo.ecoeats.domain.use_cases.get_recipes_by_title.GetRecipesByTitleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    val getRecipesUseCase: GetRecipesUseCase,
    val getRecipesByTitleUseCase: GetRecipesByTitleUseCase
) : ViewModel() {

    var state by mutableStateOf(RecipeScreenState())
        private set

    // var formState by mutableStateOf(RecipeFormState())
    //    private set

    private val _formState = MutableStateFlow(RecipeFormState())
    val formState : StateFlow<RecipeFormState> = _formState.asStateFlow()

    fun onEvent(onEvent: RecipeFormEvent) {
        when (onEvent) {
            RecipeFormEvent.GetRecipes -> {
                getRecipes()
            }

            RecipeFormEvent.GetRecipesByTitle -> {
                getRecipesByTitle()
            }

            is RecipeFormEvent.TitleChange -> {
                _formState.update { it.copy(searchValue = onEvent.searchValue) }
                // formState = formState.copy(searchValue = onEvent.searchValue)

            }
        }
    }

    private fun getRecipes() {

        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val response = withContext(Dispatchers.IO) {
                getRecipesUseCase()
            }
            when (response) {
                is Result.Error -> {
                    state = state.copy(error = response.message, isLoading = false)
                }

                is Result.Success -> {
                    state = state.copy(success = response.data, isLoading = false)
                }

                is Result.Validation -> TODO()
            }
        }
    }

    private fun getRecipesByTitle() {
        viewModelScope.launch{

            formState
                .debounce(1000)
                .map { it.searchValue }
                .distinctUntilChanged()
                .flatMapLatest {searchValue ->
                    getRecipesByTitleUseCase(searchValue)
                }.onEach { result ->

                    when(result) {
                        is Result.Error -> {
                            state = state.copy(error = result.message, isLoading = false)
                        }
                        is Result.Success -> {
                            state = state.copy(success = result.data, isLoading = false)
                        }
                        is Result.Validation -> {

                        }
                    }

                }.launchIn(viewModelScope)

            /*
            state = state.copy(isLoading = true)

            val response = withContext(Dispatchers.IO){
                getRecipesByTitleUseCase(formState.searchValue)
            }
            when (response) {
                is Result.Error -> {
                    state = state.copy(error = response.message, isLoading = false)
                }

                is Result.Success -> {
                    state = state.copy(success = response.data, isLoading = false)
                }

                is Result.Validation -> TODO()
            }
            */

        }

    }


}