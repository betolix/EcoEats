package io.h3llo.ecoeats.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.h3llo.ecoeats.data.database.model.DocumentTypeEntity


@Dao
interface DocumentTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insert( documentTypeEntity: DocumentTypeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertAll(documentTypes: List<DocumentTypeEntity>)

    @Update
    fun update (documentTypeEntity: DocumentTypeEntity)

    @Delete
    fun delete(documentTypeEntity: DocumentTypeEntity)

    @Query("SELECT * FROM document_type order by description desc")
    fun getDocumentTypes() : List<DocumentTypeEntity>

    @Query ("SELECT *FROM document_type where id=:id limit 1")
    fun getDocumentTypeById(id: Int) : DocumentTypeEntity

}