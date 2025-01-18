package com.paulchibamba.deeply.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val category: Int, // 0: DEEP_WORK, 1: SHALLOW_WORK
    val priority: Int, // 0: HIGH, 1: MEDIUM, 2: LOW
    val status: Int,   // 0: NOT_STARTED, 1: IN_PROGRESS, 2: COMPLETED
    val estimatedDurationMillis: Long,
    val actualDurationMillis: Long?,
    val scheduledDateMillis: Long,
    val scheduledTimeMillis: Long?,
    val completedAtMillis: Long?,
    val parentTaskId: Long?,
    val projectId: Long?
)
fun Task.getPriorityColor(): Color {
    return when (priority) {
        0 -> Priority.HIGH.color
        1 -> Priority.MEDIUM.color
        2 -> Priority.LOW.color
        else -> Priority.NONE.color
    }
}

fun Task.getCategoryId(): Int {
    return when (category) {
        0 -> WorkType.DEEP_WORK.id
        1 -> WorkType.SHALLOW_WORK.id
        else -> WorkType.UNDEFINED.id
    }
}