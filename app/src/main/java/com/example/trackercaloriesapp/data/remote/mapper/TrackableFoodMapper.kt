package com.example.trackercaloriesapp.data.remote.mapper

import com.example.trackercaloriesapp.app.tracker.model.TrackableFood
import com.example.trackercaloriesapp.data.remote.dto.Product
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {
    val carbsPer100g = nutriments.carbohidrate100g.roundToInt()
    val proteinsPer100g = nutriments.proteins100g.roundToInt()
    val fatPer100g = nutriments.fat100g.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g.roundToInt()
    return TrackableFood(
        name = productName ?: return  null,
        imageURL = imageFromThumbUrl,
        carbPer100g = caloriesPer100g,
        proteinPer100g = proteinsPer100g,
        fatPer100g = proteinsPer100g,
        caloriesPer100g = carbsPer100g
    )
}