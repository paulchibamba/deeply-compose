package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "goal")
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val deadlineMillis: Long?,
    val status: Int, // 0: NOT_STARTED, 1: IN_PROGRESS, 2: COMPLETED
    val type: Int,   // 0: DEEP_WORK_HOURS, 1: TASK_COMPLETION, 2: HABIT_FORMATION
    val parentGoalId: Long?,
    val currentProgress: Float = 0f,
    val targetProgress: Float = 0f
)
