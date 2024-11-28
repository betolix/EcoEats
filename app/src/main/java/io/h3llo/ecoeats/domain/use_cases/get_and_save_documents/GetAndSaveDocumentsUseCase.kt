package io.h3llo.ecoeats.domain.use_cases.get_and_save_documents

import io.h3llo.ecoeats.core.Result
import io.h3llo.ecoeats.domain.repository.DocumentTypeRepository
import javax.inject.Inject

class GetAndSaveDocumentsUseCase @Inject constructor(
    val documentTypeRepository: DocumentTypeRepository
) {

    suspend operator fun invoke() {

        // GET THE DOCUMENT TYPES FROM THE SERVER
        val documents = documentTypeRepository.getDocumentTypes()
        when (documents) {
            is Result.Error -> TODO()

            is Result.Success -> {
                documents.data?.let {
                    // SAVE DOCUMENT TYPES INTO THE LOCAL DB
                    documentTypeRepository.saveDocumentTypes(it)
                }
            }

            is Result.Validation -> TODO()
        }

    }

}