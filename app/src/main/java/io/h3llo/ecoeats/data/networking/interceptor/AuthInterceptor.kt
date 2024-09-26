package io.h3llo.ecoeats.data.networking.interceptor

import android.content.SharedPreferences
import io.h3llo.ecoeats.data.util.Util.getToken
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class AuthInterceptor @Inject constructor(
    @Named("provideSharedPreferencesEncrypted") val sharedPreferences: SharedPreferences,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val token = sharedPreferences.getToken()
        val request = if(token.isNotEmpty()){

            chain.request()
                .newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            chain.request()
                .newBuilder()
                .build()

        }
        return chain.proceed(request)

    }
}