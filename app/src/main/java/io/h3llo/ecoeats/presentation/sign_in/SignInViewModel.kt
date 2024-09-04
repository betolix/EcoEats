package io.h3llo.ecoeats.presentation.sign_in


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun signIn(email: String, password: String) {

        val repository = AuthRepository()

        state = state.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    repository.signIn(email, password)
                }

                when(response){
                    is Result.Error -> {
                        state = state.copy(isLoading = false, error = response.message)
                    }
                    is Result.Success -> {
                        state = state.copy(isLoading = false, success =  response.data)
                    }
                }

            }catch (ex:Exception){
                state = state.copy(error = ex.message, isLoading = false)
            }

        }


    }

}













