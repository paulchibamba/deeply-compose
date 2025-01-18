package com.paulchibamba.deeply.utils

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