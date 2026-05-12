package com.project.trackrun.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
@Suppress("DEPRECATION")
val appModule = module {
    single<SharedPreferences> {
        EncryptedSharedPreferences.create(
            androidApplication(),
            "auth_pref",
            MasterKey.Builder(androidApplication())
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}
