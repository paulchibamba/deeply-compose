package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity(tableName = "habit")
data class Habit(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String?,
    val frequency: Int, // 0: DAILY, 1: WEEKLY, 2: SPECIFIC_DAYS
    val timeOfDayMillis: Long?,
    val streak: Int = 0,
    val lastCompletedMillis: Long?,
    val associatedGoalId: Long?
)