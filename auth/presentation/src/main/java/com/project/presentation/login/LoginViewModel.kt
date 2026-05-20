package com.project.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.domain.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class LoginViewModel(
    private val authRepository: AuthRepository
): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    val eventFlow = Channel<LoginEvent>()
    val events = eventFlow.receiveAsFlow()

    fun onAction(action: LoginAction) {

    }
}