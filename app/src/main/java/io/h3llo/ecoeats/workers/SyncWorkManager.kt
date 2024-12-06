package io.h3llo.ecoeats.workers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.h3llo.ecoeats.domain.use_cases.get_and_save_documents.GetAndSaveDocumentsUseCase
import io.h3llo.ecoeats.presentation.util.Util.isInternetAvailable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@HiltWorker
class SyncWorkManager @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val getAndSaveDocumentsUseCase: GetAndSaveDocumentsUseCase
) : Worker(context, workerParams) {

    private val workerScope = CoroutineScope(Dispatchers.IO)

    override fun doWork(): Result {

        if (applicationContext.isInternetAvailable()) {
            Task()
            return Result.success()
        } else {
            return Result.failure()
        }
        // println("Work")

    }

    private fun Task() {

        println("Work 2")
        workerScope.launch {
            getAndSaveDocumentsUseCase()
        }

    }


}