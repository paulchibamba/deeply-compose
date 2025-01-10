package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Entity(tableName = "habit")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String,
    val frequency: HabitFrequency,
    val timeOfDay: LocalTime?,
    val streak: Int = 0,
    val lastCompletedDate: LocalDate? = null,
    val associatedGoalId: Long? = null,
)
