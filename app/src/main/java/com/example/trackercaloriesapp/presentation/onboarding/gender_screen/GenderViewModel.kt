package com.example.trackercaloriesapp.presentation.onboarding.gender_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.trackercaloriesapp.core.domain.model.Gender
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import com.example.trackercaloriesapp.core.domain.util.UIEvent
import kotlinx.coroutines.launch

class GenderViewModel(): ViewModel(){

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            _uiEvent.send(UIEvent.Success)
        }
    }
}