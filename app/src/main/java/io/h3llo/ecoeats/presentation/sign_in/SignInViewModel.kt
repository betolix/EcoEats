package io.h3llo.ecoeats.presentation.sign_in


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.use_cases.get_and_save_documents.GetAndSaveDocumentsUseCase
import io.h3llo.ecoeats.domain.use_cases.sign_in_use_case.SignInUseCase
import io.h3llo.ecoeats.domain.use_cases.validate_field_use_case.ValidateFieldUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

    // val repository: AuthRepository
    val signInUseCase: SignInUseCase,
    val validateFieldUseCase: ValidateFieldUseCase,
    val getAndSaveDocumentsUseCase: GetAndSaveDocumentsUseCase

) : ViewModel() {

    //COMPONENT STATE
    var formState by mutableStateOf(LoginFormState())

    //SCREEN STATE
    var state by mutableStateOf(LoginScreenState())

    // INIT BLOCK
    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getAndSaveDocumentsUseCase()
            }
        }
    }

    //EVENTS
    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChange -> {
                formState = formState.copy(email = event.email)
            }

            is LoginFormEvent.PasswordChange -> {
                formState = formState.copy(password = event.password)
            }

            LoginFormEvent.Submit -> {
                signIn()
            }

            is LoginFormEvent.VisualTransformationChange -> {
                formState = formState.copy(visualTransformation = event.visualTransformation)
            }

            LoginFormEvent.onFocusChange -> {
                formState = formState.copy(emailError = null)
            }

            is LoginFormEvent.showDialog -> {
                formState = formState.copy(showDialog = event.isVisible)
            }
        }
    }


    fun signIn() {

        // val repository = AuthRepository()


        state = state.copy(isLoading = true)

        viewModelScope.launch {
            try {

                delay(3000) // JUST TO OBSERVE THE LOTTIE
                /*
                val result = validateFieldUseCase(formState.email)

                if(!result.successful){
                    // email field is empty, send message to the view
                    formState = formState.copy(emailError = result.errorMessage )
                    state = state.copy(isLoading = false)
                    return@launch
                }
                 */

                val response = withContext(Dispatchers.IO) {
                    // repository.signIn(formState.email, formState.password)
                    signInUseCase(formState.email, formState.password)
                }

                when (response) {
                    is Result.Error -> {
                        state =
                            state.copy(isLoading = false, error = response.message, success = null)
                    }

                    is Result.Success -> {
                        state = state.copy(isLoading = false, success = response.data, error = null)
                    }

                    is Result.Validation -> {
                        formState = formState.copy(emailError = response.message)
                        state = state.copy(isLoading = false)

                    }
                }

            } catch (ex: Exception) {
                state = state.copy(error = ex.message, isLoading = false)
            }

        }


    }

}













