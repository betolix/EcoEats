package io.h3llo.ecoeats.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.h3llo.ecoeats.data.database.dao.DocumentTypeDao
import io.h3llo.ecoeats.data.database.model.DocumentTypeEntity

@Database(
    entities = [DocumentTypeEntity::class],
    version = 3
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun documentTypeDao() : DocumentTypeDao
}