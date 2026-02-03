package com.example.trackercaloriesapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trackercaloriesapp.R
import com.example.trackercaloriesapp.presentation.search.components.SearchTextField
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@Composable
fun SearchScreen(
    snackbarHoststate: SnackbarHostState,
    mealName: String,
    dayOfMonth: Int,
    month: Int,
    year: Int,
    onNavigateUp: () -> Unit,
    searchScreenViewModel: SearchScreenViewModel = hiltViewModel()

) {
    val spacing = LocalSpacing.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier.fillMaxSize().padding(spacing.spaceMedium)
    ) {
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        Text(
            text = stringResource(id = R.string.add_meal, mealName),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        SearchTextField(
            text = "",
            onValueChange = {},
            shouldShowHint = true,
            onSearch = {
                searchScreenViewModel.executeSearch()
                keyboardController?.hide()
            },
            onFocusChanged = {}
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    PlatziCaloriesTheme {
        SearchScreen(
            snackbarHoststate = SnackbarHostState(),
            mealName = "BreakFast",
            dayOfMonth = 1,
            month = 1,
            year = 2021,
            onNavigateUp = {}
        )
    }
}