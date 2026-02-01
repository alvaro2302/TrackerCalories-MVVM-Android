package com.example.trackercaloriesapp.presentation.onboarding.goal_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackercaloriesapp.core.domain.model.GoalType
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import com.example.trackercaloriesapp.core.domain.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

import kotlinx.coroutines.launch

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {
    var selectedGoal by mutableStateOf<GoalType>(
        GoalType.KeepWeight
    )
        private  set
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalTypeSelect(goalType: GoalType) {
        selectedGoal = goalType
    }
    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGoalType(selectedGoal)
            _uiEvent.send(UIEvent.Success)
        }
    }
}