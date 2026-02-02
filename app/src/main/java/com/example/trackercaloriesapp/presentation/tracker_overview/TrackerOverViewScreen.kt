package com.example.trackercaloriesapp.presentation.tracker_overview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trackercaloriesapp.presentation.tracker_overview.components.NutrientsHeaders
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@Composable
fun TrackerOverViewScreen(
    trackerOverViewModel: TrackerOverViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = Modifier.fillMaxSize().
        padding(spacing.spaceMedium)
    ) {
        item {
            NutrientsHeaders()
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
    }
}
@Composable
fun TrackerOverViewScreenTest(
) {
    val spacing = LocalSpacing.current
    LazyColumn(
            modifier = Modifier.fillMaxSize().
            padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeaders()
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
        }
    }

}





@Preview(showBackground = true)
@Composable
private fun TrackerOverViewScreenPreview() {
    PlatziCaloriesTheme {
        TrackerOverViewScreenTest()
    }
}