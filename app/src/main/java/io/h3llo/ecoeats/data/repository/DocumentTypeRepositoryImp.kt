package io.h3llo.ecoeats.data.repository

import io.h3llo.ecoeats.data.networking.endpoints.MethodsApi
import io.h3llo.ecoeats.data.networking.model.DocumentTypeDto
import io.h3llo.ecoeats.domain.repository.DocumentTypeRepository
import javax.inject.Inject
import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.data.database.dao.DocumentTypeDao
import io.h3llo.ecoeats.data.networking.model.mapToEntity

class DocumentTypeRepositoryImp @Inject constructor(
    val api : MethodsApi,
    val dao: DocumentTypeDao
) : DocumentTypeRepository {
    override suspend fun getDocumentTypes(): Result<List<DocumentTypeDto>> {


        try {
            val response = api.getDocumentTypes()

            if (response.isSuccessful) {
                return Result.Success(data = response.body()?.data)

            } else {
                return Result.Error(message = response.message())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }



    }

    override suspend fun saveDocumentTypes(documentTypeDto: List<DocumentTypeDto>) {

        dao.insertAll(documentTypes = documentTypeDto.mapToEntity() )
    }

}