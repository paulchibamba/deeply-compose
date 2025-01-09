package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import kotlin.time.Duration

@Entity(tableName = "sessions")
data class DeepWorkSession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val plannedDuration: Duration,
    val actualDuration: Duration? = null,
    val taskId: Long?,
    val interruptions: Interruption


)
