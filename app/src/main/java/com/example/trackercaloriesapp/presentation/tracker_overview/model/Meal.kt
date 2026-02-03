package com.example.trackercaloriesapp.presentation.tracker_overview.model

import androidx.annotation.DrawableRes
import com.example.trackercaloriesapp.R
import com.example.trackercaloriesapp.app.tracker.model.MealType
import com.example.trackercaloriesapp.core.domain.util.UiText

data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val proteins: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false,
)

val defaultMeals = listOf<Meal>(
    Meal(
        name = UiText.StringResources(R.string.breakfast),
        drawableRes = R.drawable.breakfast_02,
        mealType = MealType. Breakfast
    ),
    Meal(
        name = UiText.StringResources(R.string.lunch),
        drawableRes = R.drawable.lunch_02,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResources(R.string.dinner),
        drawableRes = R.drawable.dinner_02,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.StringResources(R.string.snacks),
        drawableRes = R.drawable.snack_02,
        mealType = MealType.Snack
    ),
)