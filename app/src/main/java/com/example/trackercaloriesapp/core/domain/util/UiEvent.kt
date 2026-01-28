package com.example.trackercaloriesapp.core.domain.util

import android.os.Message

sealed class UIEvent {
    data object Success: UIEvent()
    data object NavigateUp: UIEvent()
    data class ShowSnackbar(val message: UiText): UIEvent()
}