package com.example.trackercaloriesapp.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackercaloriesapp.app.tracker.usercase.TrackerUseCase
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackerOverViewModel @Inject constructor(
    preferences: Preferences,
    private val trackerUseCase: TrackerUseCase
) : ViewModel() {
    init {
        preferences.saveShouldShowOnboarding(false)
        executeFoodApi()
    }

    fun executeFoodApi() {
        viewModelScope.launch {
            trackerUseCase.searchFoodUseCase("egg")
        }
    }
}