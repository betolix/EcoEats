package io.h3llo.ecoeats.data.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATIONS_1_2 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {

        // NEW TEMP TABLE WITH THE NEW SCHEME CREATED
        database.execSQL(
            """
                CREATE TABLE document_type_new (
                    id INTEGER NOT NULL PRIMARY KEY,
                    description TEXT NOT NULL,
                    status INTEGER NOT NULL
                )
            """
        )

        // COPYING DATA FROM THE OLD TABLE TO THE NEW ONE
        database.execSQL(
            """
                INSERT INTO document_type_new (id, description, status)
                SELECT id, description, status
                FROM document_type
            """
        )

        // DROP THE OLD TABLE
        database.execSQL("DROP TABLE document_type")

        // RENAME NEW TABLE TO THE OLD NAME
        database.execSQL("ALTER TABLE document_type_new RENAME TO document_type")

    }

}


val MIGRATIONS_2_3 = object : Migration(2,3){
    override fun migrate(database: SupportSQLiteDatabase) {

        // NEW TEMP TABLE WITH THE NEW SCHEME CREATED
        database.execSQL(
            """
                CREATE TABLE document_type_new (
                    id INTEGER NOT NULL,
                    description TEXT NOT NULL,
                    status INTEGER NOT NULL,
                    user TEXT,
                    PRIMARY KEY (id)
                )
            """
        )

        // COPYING DATA FROM THE OLD TABLE TO THE NEW ONE
        database.execSQL(
            """
                INSERT INTO document_type_new (id, description, status, user)
                SELECT id, description, status, NULL
                FROM document_type
            """
        )

        // DROP THE OLD TABLE
        database.execSQL("DROP TABLE document_type")

        // RENAME NEW TABLE TO THE OLD NAME
        database.execSQL("ALTER TABLE document_type_new RENAME TO document_type")

    }

}