package com.project.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinimumCharacters = password.length >= MIN_CHARACTER
        val hasNumber = password.any { it.isDigit() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasUpperCase = password.any { it.isUpperCase() }

        return PasswordValidationState(
            hasMinLen = hasMinimumCharacters,
            hasDigit = hasNumber,
            hasLowerCase = hasLowerCase,
            hasUpperCase = hasUpperCase
        )
    }
    companion object {
        const val MIN_CHARACTER = 9
    }
}