package com.example.trackercaloriesapp.presentation.tracker_overview

import androidx.lifecycle.ViewModel
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrackerOverViewModel @Inject constructor(
    preferences: Preferences
) : ViewModel() {
    init {
        preferences.saveShouldShowOnboarding(false)
    }
}