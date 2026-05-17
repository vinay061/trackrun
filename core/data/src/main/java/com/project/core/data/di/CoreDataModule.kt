package com.project.core.data.di

import com.project.core.data.auth.EncryptedSessionStorage
import com.project.core.data.networking.HttpClientFactory
import com.project.domain.session.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}