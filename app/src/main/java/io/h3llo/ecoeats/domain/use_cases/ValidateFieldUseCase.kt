package io.h3llo.ecoeats.domain.use_cases

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.User

class ValidateFieldUseCase {

    operator fun invoke (email : String): ValidateResult {

        if(email.isEmpty()){
            return ValidateResult(
                successful = false,
                errorMessage = "The email field must have data"
            )
        }
        return ValidateResult(
            successful = true
        )
    }
}

data class ValidateResult(

    val successful : Boolean,
    val errorMessage : String?=null
)