package io.h3llo.ecoeats.data.networking

import io.h3llo.ecoeats.data.networking.model.DishResponse
import io.h3llo.ecoeats.data.networking.model.LoginRequest
import io.h3llo.ecoeats.data.networking.model.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

object Api {

    // URL -> http://betolix-001-site1.etempurl.com/api/securities/login
    // BASE_URL -> http://betolix-001-site1.etempurl.com
    // METHOD -> /api/securities/login

    //1. CONFIGURE RETROFIT
    //2. DEFINE METHODS
    //3. RETURN AN INSTANCE

    //interceptor
    val interceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val clientBuilder = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60,TimeUnit.SECONDS)
        .readTimeout(60,TimeUnit.SECONDS)
        .addInterceptor(interceptor)



    // 1.
    val retrofit = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientBuilder.build())
        .build()

    // 2.
    interface MethodsApi{

        @POST("api/securities/login")
        suspend fun signIn(@Body request: LoginRequest) : Response<LoginResponse>

        @GET("api/dish")
        suspend fun getDishes(
            @Header("Authorization") token:String
        ) : Response<DishResponse>
    }

    // 3.
    fun build(): MethodsApi{
        return retrofit.create(MethodsApi::class.java)
    }





}