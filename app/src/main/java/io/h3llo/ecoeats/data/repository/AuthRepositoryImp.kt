package io.h3llo.ecoeats.data.repository

import android.content.SharedPreferences
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.mapper.AuthDtoMapper
import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.networking.model.LoginRequest
import io.h3llo.ecoeats.data.networking.model.toUser
import io.h3llo.ecoeats.data.util.Util.save
import io.h3llo.ecoeats.domain.model.User
import io.h3llo.ecoeats.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImp @Inject constructor(
    @Named("provideSharedPreferencesEncrypted") val sharedPreferences: SharedPreferences,
    val api : MethodsApi,
    val authDtoMapper: AuthDtoMapper
) : AuthRepository {

    /*
    suspend fun signIn(email: String, password: String): Result<User> {
        try {
            val response = api.signIn(
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

                    return Result.Success(data = data?.data?.toUser())
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

     */

    override suspend fun signIn(email: String, password: String):  Result<User> {

        try {
            val response = api.signIn(
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

                    //return Result.Success(data = data?.data?.toUser())
                    return Result.Success(data = authDtoMapper.mapToDomainModel( data.data ))

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