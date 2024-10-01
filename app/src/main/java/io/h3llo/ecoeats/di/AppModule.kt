package io.h3llo.ecoeats.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.h3llo.ecoeats.data.mapper.AuthDtoMapper
import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.repository.AuthRepositoryImp
import io.h3llo.ecoeats.domain.repository.AuthRepository
import io.h3llo.ecoeats.domain.use_cases.SignInUseCase
import io.h3llo.ecoeats.domain.use_cases.ValidateFieldUseCase
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("provideSharedPreferences")
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("PREFERENCES_TOKEN", 0)
    }

    @Provides
    @Singleton
    @Named("provideSharedPreferencesEncrypted")
    fun provideSharedPreferencesEncrypted(@ApplicationContext context: Context): SharedPreferences {

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            "PREFERENCES_TOKEN",
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }


    @Provides
    @Singleton
    fun providesAuthDtoMapper(): AuthDtoMapper {
        return AuthDtoMapper()
    }


    @Provides
    @Singleton
    fun provideSignInUseCase(authRepository: AuthRepository): SignInUseCase {
        return SignInUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideValidateFieldUseCase(): ValidateFieldUseCase {
        return ValidateFieldUseCase()
    }


}