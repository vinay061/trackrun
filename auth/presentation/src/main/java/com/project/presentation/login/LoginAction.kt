package com.project.presentation.login

sealed interface LoginAction {
    data object OnLoginClick: LoginAction
    data object OnRegisterClick: LoginAction
    data object OnTogglePassword: LoginAction
}