package io.h3llo.ecoeats.data.networking.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    // This is a DTO

    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: UserDto,


    )

data class UserDto(
    // This is a DTO as well
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String,
    @SerializedName("tokenFirebaseAuth") val tokenFirebaseAuth: String,
)

