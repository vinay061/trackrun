package com.project.trackrun

import android.app.Application
import com.project.auth.data.di.authDataModule
import com.project.core.data.BuildConfig
import com.project.core.data.di.coreDataModule
import com.project.presentation.di.authViewModelModule
import com.project.trackrun.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class TrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@TrackerApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                coreDataModule
            )
        }
    }
}