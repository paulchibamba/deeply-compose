package com.paulchibamba.deeply.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun Long.toDynamicDuration(): String {
    val totalSeconds = this / 1000
    val minutes = totalSeconds / 60
    val hours = minutes / 60

    return when {
        hours > 0 -> "$hours hr${if (hours > 1) "s" else ""}"
        minutes > 0 -> "$minutes min${if (minutes > 1) "s" else ""}"
        else -> "$totalSeconds sec${if (totalSeconds > 1) "s" else ""}"
    }
}

fun Long.toFormattedDate(): String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    return dateFormat.format(date)
}


fun Long.daysUntil(): String {
    val currentTime = System.currentTimeMillis()
    val difference = this - currentTime

    return when {
        difference <= 0 -> "Overdue"
        else -> {
            val daysLeft = TimeUnit.MILLISECONDS.toDays(difference)
            "$daysLeft day${if (daysLeft > 1) "s" else ""} left"
        }
    }
}