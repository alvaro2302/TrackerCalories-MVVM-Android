package com.example.trackercaloriesapp.presentation.tracker_overview.components

import android.R
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme

@Composable
fun NutrientsHeaders(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val animatedCaloriesCount = animateIntAsState(
        targetValue = 2000
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSurfaceVariant)
            .padding(
            horizontal = spacing.spaceLarge,
            vertical = spacing.spaceExtraLarge
            ),
        ){
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Nutrient(
                value = 100,
                goal = 200,
                name = "Carbs",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(90.dp)
            )
            Nutrient(
                value = 50,
                goal = 150,
                name = "Proteins",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(90.dp)
            )
            Nutrient(
                value = 300,
                goal = 500,
                name = "Fat",
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(90.dp)
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = animatedCaloriesCount.value,
                unit = "kcal",
                amountColor = MaterialTheme.colorScheme.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colorScheme.onPrimary
            )
            Column {
                Text(
                    text = "your Goal:",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                UnitDisplay(
                    amount = 2550,
                    unit ="kcal",
                    amountColor = MaterialTheme.colorScheme.onPrimary,
                    amountTextSize = 40.sp,
                    unitColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NutrientsHeadersPreview() {
    PlatziCaloriesTheme {
        NutrientsHeaders()
    }
}
