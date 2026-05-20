package com.project.presentation.login

sealed interface LoginAction {
    data object OnLoginClick: LoginAction
    data object OnSignUpClick: LoginAction
    data object OnTogglePassword: LoginAction
}