package com.example.trackercaloriesapp.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trackercaloriesapp.presentation.onboarding.gender_screen.GenderScreen
import com.example.trackercaloriesapp.presentation.onboarding.goal_screen.GoalScreen
import com.example.trackercaloriesapp.presentation.onboarding.height_screen.HeightScreen
import com.example.trackercaloriesapp.presentation.onboarding.level_screen.LevelScreen
import com.example.trackercaloriesapp.presentation.onboarding.nutrient_goal_screen.NutrientGoalScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = GenderScreenRoute
        ) {
            composable<GenderScreenRoute> {
                GenderScreen {
                    navHostController.navigate(HeightScreenRoute)
                }
            }
            composable<HeightScreenRoute> {
                HeightScreen {
                    navHostController.navigate(GoalScreenRoute)
                }
            }
            composable<GoalScreenRoute> {
                GoalScreen {
                    navHostController.navigate(LevelScreenRoute)
                }
            }
            composable<LevelScreenRoute> {
                LevelScreen {
                    navHostController.navigate(NutrientScreenRoute)
                }
            }
            composable<NutrientScreenRoute> {
                NutrientGoalScreen()
            }
        }
    }
}