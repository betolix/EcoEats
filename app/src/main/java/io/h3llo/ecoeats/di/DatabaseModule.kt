package io.h3llo.ecoeats.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.h3llo.ecoeats.data.database.AppDatabase
import io.h3llo.ecoeats.data.database.dao.DocumentTypeDao
import io.h3llo.ecoeats.data.database.migrations.MIGRATIONS_1_2
import io.h3llo.ecoeats.data.database.migrations.MIGRATIONS_2_3
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context ) : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "DB_ECOEATS"
    ).addMigrations(MIGRATIONS_1_2, MIGRATIONS_2_3)
        .build()

    @Provides
    @Singleton
    fun provideDocumentTypeDao(appDatabase: AppDatabase) : DocumentTypeDao = appDatabase.documentTypeDao()
}