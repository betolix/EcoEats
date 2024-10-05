package io.h3llo.ecoeats.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.h3llo.ecoeats.BuildConfig
import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.networking.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun provideAuthInterceptor(@Named("provideSharedPreferencesEncrypted") sharedPreferences: SharedPreferences): AuthInterceptor{
        return AuthInterceptor(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideInterceptor(authInterceptor: AuthInterceptor) : OkHttpClient{
        val interceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(3, TimeUnit.SECONDS)
            .writeTimeout(3, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)

        return clientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(clientBuilder : OkHttpClient ): MethodsApi = Retrofit.Builder()
        //.baseUrl(Constants.URL_BASE)
        .baseUrl(BuildConfig.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientBuilder)
        .build()
        .create()

}