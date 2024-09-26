package io.h3llo.ecoeats.data.repository

import android.content.SharedPreferences
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.networking.model.toDishList
import io.h3llo.ecoeats.data.util.Util.getToken
import io.h3llo.ecoeats.domain.model.Dish
import javax.inject.Inject
import javax.inject.Named

class DishesRepository @Inject constructor(
    @Named("provideSharedPreferencesEncrypted") val sharedPreferences : SharedPreferences,
    val api : MethodsApi
) {

    suspend fun getDishes(): Result<List<Dish>> {

        try {
            val token = sharedPreferences.getToken()
            //val response = api.getDishes("Bearer $token")
            val response = api.getDishes()

            if (response.isSuccessful) {
                return Result.Success(data = response.body()?.data?.toDishList())

            } else {
                return Result.Error(message = response.message())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }

    }
}