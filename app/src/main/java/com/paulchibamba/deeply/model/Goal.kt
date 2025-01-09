package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "goal")
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val deadline: LocalDate?,
    val type: GoalType,
    val currentProgress: Float = 0f,
    val targetProgress: Float = 0f
)
