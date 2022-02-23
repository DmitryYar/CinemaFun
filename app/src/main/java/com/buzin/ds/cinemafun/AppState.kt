package com.buzin.ds.cinemafun

sealed class AppState() {
    data class Error(val error: Throwable): AppState()
    data class Success(val film: Any): AppState()
    object Loading: AppState()

}
