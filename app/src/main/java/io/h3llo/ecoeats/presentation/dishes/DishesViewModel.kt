package io.h3llo.ecoeats.presentation.dishes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.repository.DishesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(val repository : DishesRepository) : ViewModel() {

    var state by mutableStateOf(DishesScreenState())
    private set

    fun getDishes(){

        // val repository : DishesRepository()

        viewModelScope.launch(Dispatchers.Main) {

            state = state.copy(isLoading = true)

            delay(5000)

            val response = withContext(Dispatchers.IO){
                repository.getDishes()
            }
            when(response){
                is Result.Error -> {
                    state = state.copy(isLoading = false, error = response.message, success = null )

                }
                is Result.Success -> {
                    state = state.copy(isLoading = false, success = response.data, error = null)

                }

                is Result.Validation -> TODO()
            }

        }

    }

}