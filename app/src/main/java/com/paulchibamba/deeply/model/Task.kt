package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration

@Entity(tableName = "task")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
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
