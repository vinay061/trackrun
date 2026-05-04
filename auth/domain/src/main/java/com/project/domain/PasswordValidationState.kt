package com.project.domain

data class PasswordValidationState(
    val hasMinLen: Boolean = false,
    val hasDigit: Boolean = false,
    val hasLowerCase: Boolean = false,
    val hasUpperCase: Boolean = false
) {
    val isValid: Boolean
        get() = hasMinLen &&
                hasDigit &&
                hasLowerCase &&
                hasUpperCase
}