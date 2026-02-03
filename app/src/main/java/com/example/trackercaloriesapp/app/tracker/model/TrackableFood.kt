package com.example.trackercaloriesapp.app.tracker.model

data class TrackableFood(
    val name: String?,
    val imageURL: String?,
    val caloriesPer100g: Int,
    val carbPer100g: Int,
    val proteinPer100g: Int,
    val fatPer100g: Int
)