package io.h3llo.ecoeats.presentation.sign_in

data class LoginFormState(
    val email:String="betolix@gmail.com",
    val emailError:String?=null,
    val password:String="123",
    val visualTransformation: Boolean = true,
    val showDialog: Boolean = false
)
