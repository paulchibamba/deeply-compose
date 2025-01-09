package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val priority: Priority,
    val category: TaskCategory,
    val status: TaskStatus,
    val estimatedDuration: Duration,
    val actualDuration: Duration? = null,
    val scheduledDate: LocalDate,
    val scheduledStartTime: LocalTime?,
    val completedAt: LocalDateTime? = null,
    val parentTaskId: Long? = null,
    val projectId: Long? = null,
    val isRepeating: Boolean = false,
    val repeatPattern: RepeatPattern? = null
)
