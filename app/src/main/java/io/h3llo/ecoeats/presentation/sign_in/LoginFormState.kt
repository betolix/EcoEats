package io.h3llo.ecoeats.presentation.sign_in

data class LoginFormState(
    val email:String="",
    val password:String="",
    val visualTransformation: Boolean = true,
)
