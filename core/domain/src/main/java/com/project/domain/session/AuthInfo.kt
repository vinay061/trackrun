package com.project.domain.session

data class AuthInfo(
    val accessToken: String,
    val refreshToken: String,
    val userId: String
)