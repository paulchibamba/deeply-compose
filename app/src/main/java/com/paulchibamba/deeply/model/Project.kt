package com.paulchibamba.deeply.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "project")
data class Project(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val priority: Int, // 0: HIGH, 1: MEDIUM, 2: LOW
    val startDateMillis: Long,
    val endDateMillis: Long,
    val status: Int // 0: ACTIVE, 1: COMPLETED, 2: ON_HOLD, 3: ARCHIVED
)


fun Project.getPriorityColor(): Color {
    return when (priority) {
        0 -> Priority.HIGH.color
        1 -> Priority.MEDIUM.color
        2 -> Priority.LOW.color
        else -> Priority.NONE.color
    }
}
