package io.h3llo.ecoeats.workers

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.work.impl.utils.ForceStopRunnable.BroadcastReceiver
import io.h3llo.ecoeats.presentation.util.Util.scheduleWork

@SuppressLint("RestrictedApi")
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        super.onReceive(context, intent)
        if(intent?.action == Intent.ACTION_BOOT_COMPLETED){

            context.scheduleWork()
        }
    }
}