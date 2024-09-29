package io.h3llo.ecoeats.domain.repository

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.model.User

interface AuthRepository {

    suspend fun signIn(email : String, password :  String) : Result<User>
}