package com.tomtre.android.architecture.shoppinglistmvp.base

import android.app.Application
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import com.tomtre.android.architecture.shoppinglistmvp.BuildConfig
import timber.log.Timber

class ShoppingListApp : Application() {
    override fun onCreate() : Unit {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        //no need to add different versions for debug and release because of debugImplementation
        //and releaseImplementation in dependencies
        LeakCanary.install(this)

        enableStrictMode()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    private fun enableStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build())
        }
    }
}