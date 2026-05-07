package com.project.trackrun

import android.app.Application
import com.project.data.di.authDataModule
import com.project.presentation.di.authViewModelModule
import com.project.trackrun.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()
//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
        startKoin {
            androidLogger()
            androidContext(this@TrackerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
            )
        }
    }
}