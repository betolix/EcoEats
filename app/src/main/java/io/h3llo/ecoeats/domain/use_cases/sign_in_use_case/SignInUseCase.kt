package io.h3llo.ecoeats.domain.use_cases.sign_in_use_case

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.User
import io.h3llo.ecoeats.domain.repository.AuthRepository
import io.h3llo.ecoeats.domain.use_cases.validate_field_use_case.ValidateFieldUseCase
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    val repository: AuthRepository,
    val validateFieldUseCase : ValidateFieldUseCase
) {

    suspend operator fun invoke (email:String, password: String) : Result<User>{

        /*
        if(email.isEmpty()){
            return Result.Validation("The email field must have data")
        }
        if(!validateEmail(email)){
            return Result.Validation("The email field must be properly formatted")
        }
         */

        val emailValidation = validateFieldUseCase(email)
        if( !emailValidation.successful ){
            return Result.Validation(message = emailValidation.errorMessage ?: "")
        }

        return repository.signIn(email, password)
    }
}

