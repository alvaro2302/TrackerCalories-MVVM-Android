package com.example.trackercaloriesapp.presentation.onboarding.components

import android.view.View
import android.widget.Button
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.platzi.android.mvvm.app.ui.theme.LocalSpacing
import com.platzi.android.mvvm.app.ui.theme.PlatziCaloriesTheme
import com.example.trackercaloriesapp.presentation.onboarding.components.ActinButton
@Composable
fun ActinButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = text,
            style = textStyle,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall)
        )

    }
}

@Preview
@Composable
private fun ActionButtonScreen() {
    PlatziCaloriesTheme {
        ActinButton(text = "Siguiente", onClick = {}, modifier = Modifier, isEnabled = true, textStyle = MaterialTheme.typography.titleSmall)
    }
}