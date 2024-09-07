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

    //ESTADOS COMPONENTES
    var formState by mutableStateOf(LoginFormState())


    //ESTADOS PANTALLA
    var state by mutableStateOf(LoginScreenState())

    //EVENTOS
    fun onEvent( event : LoginFormEvent){
        when(event){
            is LoginFormEvent.EmailChange -> {
                formState = formState.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChange -> {
                formState = formState.copy(password =  event.password )
            }
            LoginFormEvent.Submit -> {
                signIn()
            }
            is LoginFormEvent.VisualTransformationChange -> {
                formState = formState.copy(visualTransformation = event.visualTransformation)
            }
        }
    }


    fun signIn() {

        val repository = AuthRepository()

        state = state.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO){
                    repository.signIn(formState.email, formState.password)
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













