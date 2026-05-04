package com.project.presentation.register

sealed interface RegisterAction {
    data object OnLoginClick: RegisterAction
    data object OnTogglePasswordVisibilityClick: RegisterAction
    data object OnRegisterClick: RegisterAction
}