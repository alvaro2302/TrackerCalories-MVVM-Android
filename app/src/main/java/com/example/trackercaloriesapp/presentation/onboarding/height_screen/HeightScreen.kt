package com.example.trackercaloriesapp.presentation.onboarding.height_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.example.trackercaloriesapp.R
import com.example.trackercaloriesapp.presentation.onboarding.components.ActionButton
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@Composable
fun HeightScreen(onNextClick: () -> Unit){
    val spacing = LocalSpacing.current
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
                text = stringResource(R.string.whats_your_height),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall

            )
            Spacer(modifier = Modifier.height(spacing.spaceSmall))

            Row {
                Text(
                    text = "180",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "cm",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall

                )
            }
        }

        ActionButton(
            text = stringResource(R.string.next),
            onClick = {onNextClick()},
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }

}

@Preview
@Composable
fun HeightScreenPreview() {
    PlatziCaloriesTheme {
        HeightScreen(onNextClick = {})
    }
}