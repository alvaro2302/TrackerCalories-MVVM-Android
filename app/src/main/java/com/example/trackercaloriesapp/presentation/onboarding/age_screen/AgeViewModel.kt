package com.example.trackercaloriesapp.presentation.onboarding.age_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackercaloriesapp.R
import com.example.trackercaloriesapp.core.domain.use_case.FilterOutDigits
import com.example.trackercaloriesapp.core.domain.util.UIEvent
import com.example.trackercaloriesapp.core.domain.util.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AgeViewModel: ViewModel() {
    private val filterOutDigits = FilterOutDigits()
    var age by mutableStateOf("20")
         private set
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onAgeEnter(age: String) {
        if(age.length <= 3) {
            this.age = filterOutDigits(age)
        }
    }
    fun onNextClick() {
        viewModelScope.launch {
            age.toIntOrNull() ?: kotlin.run {
            _uiEvent.send(
                UIEvent.ShowSnackbar(UiText.StringResources(R.string.error_age_cant_be_empty))
            )
            return@launch
            }
            _uiEvent.send(UIEvent.Success)
        }
    }

}