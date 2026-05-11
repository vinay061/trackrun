package com.project.domain

import com.project.domain.util.DataError
import com.project.domain.util.EmptyResult

interface AuthRepository {
    suspend fun Register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network>
}