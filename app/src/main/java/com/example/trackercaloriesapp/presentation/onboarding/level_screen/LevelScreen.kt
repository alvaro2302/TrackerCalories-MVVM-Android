package com.example.trackercaloriesapp.presentation.onboarding.level_screen

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.example.trackercaloriesapp.R
import com.example.trackercaloriesapp.core.data.preferences.DefaultPreferences
import com.example.trackercaloriesapp.core.domain.model.ActivityLevel
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import com.example.trackercaloriesapp.core.domain.util.UIEvent
import com.example.trackercaloriesapp.presentation.onboarding.components.ActionButton
import com.example.trackercaloriesapp.presentation.onboarding.components.SelectableButton
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@Composable
fun LevelScreen(
    onNextClick : () -> Unit,
    activityLevel: LevelViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        activityLevel.uiEvent.collect { event ->
            when (event) {
                is UIEvent.Success -> onNextClick()
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(spacing.spaceLarge)

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.whats_your_activity_level),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodySmall,

            )
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            Row {
                SelectableButton(
                    text = stringResource(R.string.low),
                    isSelected = activityLevel.selectedActivityLevel is ActivityLevel.Low,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevel.onActivityLevelSelect(ActivityLevel.Low) },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(R.string.medium),
                    isSelected = activityLevel.selectedActivityLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevel.onActivityLevelSelect(ActivityLevel.Medium)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(R.string.high),
                    isSelected =  activityLevel.selectedActivityLevel is ActivityLevel.High,
                    color = MaterialTheme.colorScheme.primary,
                    selectedTextColor = Color.White,
                    onClick = {
                        activityLevel.onActivityLevelSelect(ActivityLevel.High)
                    },
                    textStyle = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal
                    )
                )


            }

        }
        ActionButton(
            text = stringResource(R.string.next),
            onClick = activityLevel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }

}

