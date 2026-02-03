package com.example.trackercaloriesapp.app.tracker.di

import com.example.trackercaloriesapp.app.tracker.repository.TrackerRepository
import com.example.trackercaloriesapp.app.tracker.usercase.SearchFoodUseCase
import com.example.trackercaloriesapp.app.tracker.usercase.TrackerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {
    @ViewModelScoped
    @Provides
    fun provideTrackerUseCase(
        trackerRepository: TrackerRepository
    ): TrackerUseCase {
        return TrackerUseCase(
            searchFoodUseCase = SearchFoodUseCase(trackerRepository)
        )
    }
}