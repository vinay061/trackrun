package com.project.auth.data.di

import com.project.auth.data.AuthRepositoryImpl
import com.project.auth.data.EmailPatternValidator
import com.project.domain.AuthRepository
import com.project.domain.PatternValidator
import com.project.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}