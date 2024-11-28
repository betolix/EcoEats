package io.h3llo.ecoeats.domain.repository

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.networking.model.DocumentTypeDto

interface DocumentTypeRepository {

    suspend fun getDocumentTypes() : Result<List<DocumentTypeDto>>
    suspend fun saveDocumentTypes(documentTypeDto: List<DocumentTypeDto>)

}