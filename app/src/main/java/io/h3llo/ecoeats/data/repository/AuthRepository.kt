package io.h3llo.ecoeats.data.repository

import android.content.SharedPreferences
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.networking.Api
import io.h3llo.ecoeats.data.networking.model.LoginRequest
import io.h3llo.ecoeats.data.networking.model.UserDto
import io.h3llo.ecoeats.data.util.Util
import io.h3llo.ecoeats.data.util.Util.save
import javax.inject.Inject
import javax.inject.Named

class AuthRepository @Inject constructor(
    @Named("provideSharedPreferencesEncrypted") val sharedPreferences: SharedPreferences
) {

    suspend fun signIn(email: String, password: String): Result<UserDto> {
        try {
            val response = Api.build().signIn(
                LoginRequest(
                    email = email, //"betolix@gmail.com",
                    password = password, //"123"
                )
            )

            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {

                    val preferences = sharedPreferences.edit()
                    // preferences.putString("KEY_TOKEN", data?.data?.token)
                    // preferences.apply()

                    // USING Util.saveSharedPreferences
                    // Util.saveTokenSharedPreferences(sharedPreferences, data?.data?.token ?: "")

                    // USING EXTENSION FUNCTIONS
                    sharedPreferences.save(data?.data?.token ?: "")

                    return Result.Success(data = data?.data)
                }else{
                    return Result.Error(message = data?.message ?: "Error desconocido")
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }

    }
}