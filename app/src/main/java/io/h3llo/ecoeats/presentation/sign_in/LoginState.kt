package io.h3llo.ecoeats.presentation.sign_in

import io.h3llo.ecoeats.data.networking.model.UserDto

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: UserDto? = null
)