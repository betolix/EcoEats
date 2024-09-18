package io.h3llo.ecoeats.data.repository

import android.content.SharedPreferences
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.networking.Api
import io.h3llo.ecoeats.data.networking.model.DishDto
import io.h3llo.ecoeats.data.util.Util.getToken
import javax.inject.Inject
import javax.inject.Named

class DishesRepository @Inject constructor(
    @Named("provideSharedPreferencesEncrypted") val sharedPreferences : SharedPreferences
) {

    suspend fun getDishes(): Result<List<DishDto>> {

        try {
            val token = sharedPreferences.getToken()
            val response = Api.build().getDishes("Bearer $token")

            if (response.isSuccessful) {
                return Result.Success(data = response.body()?.data)

            } else {
                return Result.Error(message = response.message())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }

    }
}