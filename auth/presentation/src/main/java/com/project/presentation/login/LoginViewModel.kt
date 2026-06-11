package com.project.presentation.login

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.domain.AuthRepository
import com.project.domain.UserDataValidator
import com.project.domain.util.DataError
import com.project.domain.util.Result
import com.project.presentation.R
import com.project.ui.UiText
import com.project.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val userDataValidator: UserDataValidator,
): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    val eventFlow = Channel<LoginEvent>()
    val events = eventFlow.receiveAsFlow()

    init {
        combine(state.email.textAsFlow(), state.password.textAsFlow()) { email, password ->
            state = state.copy(
                canLogin = userDataValidator.isValidEmail(email = email.toString().trim()) &&
                        password.isNotBlank()
            )
        }.launchIn(viewModelScope)
    }
    fun onAction(action: LoginAction) {
        when(action) {
            LoginAction.OnLoginClick -> login()
            LoginAction.OnTogglePassword -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }

            else -> Unit
        }
    }

    private fun login() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)
            val result = authRepository.Login(
                state.email.text.toString().trim(),
                state.password.text.toString()
            )
            state = state.copy(isLoggingIn = false)
            when(result) {
                is Result.Error -> {
                    if(result.error == DataError.Network.UNAUTHORIZED) {
                        eventFlow.send(LoginEvent.Error(
                            UiText.StringResource(R.string.error_email_password_incorrect)))
                    } else {
                        eventFlow.send(LoginEvent.Error(result.error.asUiText()))
                    }

                }
                is Result.Success -> {
                    eventFlow.send(LoginEvent.LoginSuccess)
                }
            }
        }
    }

    private fun TextFieldState.textAsFlow(): Flow<CharSequence> {
        return snapshotFlow { text }
    }
}