package com.example.trackercaloriesapp.presentation.tracker_overview.components

import androidx.compose.runtime.Composable

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ParseDateText(
    date: LocalDate
): String {
    val today = LocalDate.now()
    return when(date) {
        today -> "Today"
        today.minusDays(1) -> "Yesterday"
        today.plusDays(1) -> "Tomorrow"
        else -> DateTimeFormatter.ofPattern("dd LLL").format(date)
    }
}