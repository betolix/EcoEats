package io.h3llo.ecoeats.presentation.sign_in

import io.h3llo.ecoeats.domain.model.User

data class LoginScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: User? = null
)