package com.example.trackercaloriesapp.app.tracker.repository

import com.example.trackercaloriesapp.app.tracker.model.TrackableFood

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page:Int,
        pageSize: Int
    ): Result<List<TrackableFood>>
}