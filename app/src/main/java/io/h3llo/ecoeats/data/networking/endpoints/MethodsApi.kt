package io.h3llo.ecoeats.data.networking.endpoints

import io.h3llo.ecoeats.data.networking.model.DishResponse
import io.h3llo.ecoeats.data.networking.model.LoginRequest
import io.h3llo.ecoeats.data.networking.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface MethodsApi {

    @POST("api/securities/login")
    suspend fun signIn(@Body request: LoginRequest) : Response<LoginResponse>

    @GET("api/dish")
    suspend fun getDishes(
        // @Header("Authorization") token:String
    ) : Response<DishResponse>

}