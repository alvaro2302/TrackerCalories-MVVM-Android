package com.example.trackercaloriesapp.core.navigation

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trackercaloriesapp.core.data.preferences.DefaultPreferences
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import com.example.trackercaloriesapp.presentation.onboarding.age_screen.AgeScreen
import com.example.trackercaloriesapp.presentation.onboarding.age_screen.AgeViewModel
import com.example.trackercaloriesapp.presentation.onboarding.gender_screen.GenderScreen
import com.example.trackercaloriesapp.presentation.onboarding.gender_screen.GenderViewModel
import com.example.trackercaloriesapp.presentation.onboarding.goal_screen.GoalScreen
import com.example.trackercaloriesapp.presentation.onboarding.height_screen.HeightScreen
import com.example.trackercaloriesapp.presentation.onboarding.level_screen.LevelScreen
import com.example.trackercaloriesapp.presentation.onboarding.nutrient_goal_screen.NutrientGoalScreen
import com.example.trackercaloriesapp.presentation.onboarding.weight_screen.WeightScreen
import com.example.trackercaloriesapp.presentation.tracker_overview.TrackerOverViewScreen
import kotlin.getValue

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NavigationRoot(
    shouldShowOnboarding: Boolean,
    navHostController: NavHostController,
    snack: SnackbarHostState
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = if (shouldShowOnboarding) {
                GenderScreenRoute
            } else {
                TrackerOverViewRoute
            }
        ) {
            composable<GenderScreenRoute> {
                GenderScreen(onNextClick = {
                    navHostController.navigate(AgeScreenRoute)
                })
            }
            composable<AgeScreenRoute> {
                AgeScreen(onNextClick = {
                    navHostController.navigate(HeightScreenRoute)
                }, snackbarState = snack)
            }
            composable<HeightScreenRoute> {
                HeightScreen(onNextClick = {
                    navHostController.navigate(WeightScreenRoute)
                }, snackbarState = snack)
            }
            composable<WeightScreenRoute> {
                WeightScreen(snackBarState = snack, onNextClick = {
                    navHostController.navigate(GoalScreenRoute)
                })
            }
            composable<GoalScreenRoute> {
                GoalScreen(onNextClick = {
                    navHostController.navigate(LevelScreenRoute)
                },)
            }
            composable<LevelScreenRoute> {
                LevelScreen(onNextClick = {
                    navHostController.navigate(NutrientScreenRoute)
                },)
            }
            composable<NutrientScreenRoute> {
                NutrientGoalScreen(snackbarState = snack, onNextClick = {
                    navHostController.navigate(TrackerOverViewRoute)
                })
            }
            composable<TrackerOverViewRoute> {
                TrackerOverViewScreen()
            }
         }
    }
}