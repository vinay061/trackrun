package com.project.data.di

import com.project.data.EmailPatternValidator
import com.project.domain.PatternValidator
import com.project.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}