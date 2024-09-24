package io.h3llo.ecoeats.data.networking.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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

data class DishResponse(
    @SerializedName("message") val message: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<DishDto>
)

data class DishDto(
    @SerializedName("carbohydrates") val carbohydrates: Int,
    @SerializedName("description") val description: String,
    @SerializedName("flagHeader") val flagHeader: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("ingredients") val ingredients: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("proteins") val proteins: Int,
    @SerializedName("rating") val rating: Double,
    @SerializedName("thumbails") val thumbails: String
) : Serializable