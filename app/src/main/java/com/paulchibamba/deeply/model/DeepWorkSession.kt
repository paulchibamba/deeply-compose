package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import kotlin.time.Duration

@Entity(tableName = "session")
data class DeepWorkSession(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val startTimeMillis: Long,
    val endTimeMillis: Long?,
    val plannedDurationMillis: Long,
    val actualDurationMillis: Long?,
    val taskId: Long?,
    val completed: Boolean = false,
    val interruptions: String? // "timestamp,reason;timestamp,reason..."
)
