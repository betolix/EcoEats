package io.h3llo.ecoeats.domain.use_cases.validate_field_use_case

import io.h3llo.ecoeats.domain.util.Util
import io.h3llo.ecoeats.domain.util.ValidateResult

class ValidateFieldUseCase {

    operator fun invoke (email : String): ValidateResult {

        if(email.isEmpty()){
            return ValidateResult(
                successful = false,
                errorMessage = "The email field must have data"
            )
        }
        if(!Util.validateEmail(email)){
            return ValidateResult(
            successful = false,
            errorMessage = "The email field must be properly formatted"
            )
        }

        return ValidateResult(
            successful = true
        )
    }
}

