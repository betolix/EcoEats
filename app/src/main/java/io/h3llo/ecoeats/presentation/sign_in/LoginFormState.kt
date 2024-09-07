package io.h3llo.ecoeats.presentation.sign_in

data class LoginFormState(
    val email:String="betolix@gmail.com",
    val password:String="123",
    val visualTransformation: Boolean = true,
)
