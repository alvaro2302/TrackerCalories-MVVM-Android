package com.example.trackercaloriesapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackercaloriesapp.app.tracker.usercase.TrackerUseCase
import com.example.trackercaloriesapp.core.domain.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val trackerUseCase: TrackerUseCase
): ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun executeSearch(){
        viewModelScope.launch {
            trackerUseCase.searchFoodUseCase("Pizza")
        }
    }
}