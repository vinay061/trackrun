package com.project.run.presentation

sealed interface RunOverviewAction {
    data object OnAnalyticsClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnStartRunClick: RunOverviewAction
}