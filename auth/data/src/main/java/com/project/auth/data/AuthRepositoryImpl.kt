package com.project.auth.data

import com.project.core.data.networking.get
import com.project.core.data.networking.post
import com.project.domain.AuthRepository
import com.project.domain.session.AuthInfo
import com.project.domain.session.SessionStorage
import com.project.domain.util.DataError
import com.project.domain.util.EmptyResult
import com.project.domain.util.Result
import com.project.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {
    override suspend fun Register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }

    override suspend fun Login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success) {
            sessionStorage.set(AuthInfo(
                accessToken = result.data.accessToken,
                refreshToken = result.data.refreshToken,
                userId = result.data.userId
            ))
        }
      return  result.asEmptyDataResult()
    }
}