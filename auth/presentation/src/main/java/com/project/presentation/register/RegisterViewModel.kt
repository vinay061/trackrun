package com.project.presentation.register

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.domain.UserDataValidator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterViewModel(
    private val userDataValidator: UserDataValidator
): ViewModel() {
    
    var state by mutableStateOf(RegisterState())
        private set

    init {
        state.email.textAsFlow()
            .onEach { email ->
                val isValidEmail = userDataValidator.isValidEmail(email.toString())
                state = state.copy(
                    isValidEmail = isValidEmail,
                    canRegister = isValidEmail && state.passwordValidationState.isValid &&
                                    !state.isRegistering
                )
            }
            .launchIn(viewModelScope)

        state.password.textAsFlow()
            .onEach { password ->
                val passWordValidationState = userDataValidator.validatePassword(password.toString())
                state = state.copy(
                    passwordValidationState = passWordValidationState,
                    canRegister = state.isValidEmail && state.passwordValidationState.isValid &&
                                    !state.isRegistering
                )
            }
            .launchIn(viewModelScope)
    }
    fun onAction(action: RegisterAction) {}

    private fun TextFieldState.textAsFlow(): Flow<CharSequence> {
        return snapshotFlow { text }
    }
}
