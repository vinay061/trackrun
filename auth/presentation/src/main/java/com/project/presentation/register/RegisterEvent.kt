package com.project.presentation.register

import com.project.ui.UiText

interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}