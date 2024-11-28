package io.h3llo.ecoeats.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "document_type")
data class DocumentTypeEntity(

    @PrimaryKey(autoGenerate = false)
    @Nonnull
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "status")
    val status: String

)
