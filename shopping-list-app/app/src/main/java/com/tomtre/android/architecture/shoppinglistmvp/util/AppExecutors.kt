package com.tomtre.android.architecture.shoppinglistmvp.util

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor

class AppExecutors
private constructor(
    val diskIOExecutor: Executor,
    val mainThreadExecutor: Executor
){

    companion object {

        val LOCK = Any()
        var INSTANCE: AppExecutors? = null

        fun getInstance(diskIOExecutor: Executor, mainThreadExecutor: Executor): AppExecutors {
            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = AppExecutors(diskIOExecutor, mainThreadExecutor)
                    }
                }
            }
            return INSTANCE!!
        }
    }

    @VisibleForTesting
    fun clearInstance() {
        INSTANCE = null
    }

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }

    }
}