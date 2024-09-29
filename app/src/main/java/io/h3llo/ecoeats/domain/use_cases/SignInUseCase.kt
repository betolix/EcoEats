package io.h3llo.ecoeats.domain.use_cases

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.repository.AuthRepositoryImp
import io.h3llo.ecoeats.domain.model.User
import io.h3llo.ecoeats.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor( val repository: AuthRepository) {

    suspend operator fun invoke (email:String, password: String) : Result<User>{

        // if (email.isEmpty() ){
        //     return
        // }

        return repository.signIn(email, password)
    }
}