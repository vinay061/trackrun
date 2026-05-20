package com.project.presentation.login

import com.project.ui.UiText

interface LoginEvent {
    data object LoginSuccess: LoginEvent
    data class Error(val error: UiText): LoginEvent
}