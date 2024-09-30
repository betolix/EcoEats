package io.h3llo.ecoeats.ui

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.h3llo.ecoeats.data.mapper.AuthDtoMapper
import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.repository.AuthRepositoryImp
import io.h3llo.ecoeats.domain.repository.AuthRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        api: MethodsApi,
        @Named("provideSharedPreferencesEncrypted") sharedPreferences: SharedPreferences,
        authDtoMapper: AuthDtoMapper
    ): AuthRepository {
        return AuthRepositoryImp(sharedPreferences, api, authDtoMapper )
    }

}