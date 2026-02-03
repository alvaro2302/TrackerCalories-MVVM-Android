package com.example.trackercaloriesapp.app.tracker.usercase

import com.example.trackercaloriesapp.app.tracker.model.TrackableFood
import com.example.trackercaloriesapp.app.tracker.repository.TrackerRepository

class SearchFoodUseCase(
    private val trackerRepository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int = 1 ,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return trackerRepository.searchFood(query.trim(),page,pageSize)
    }
}