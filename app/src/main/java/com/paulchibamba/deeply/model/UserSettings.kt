package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

@Entity(tableName = "user_settings")
data class UserSettings(
    @PrimaryKey val id: Int = 1,
    val deepWorkStyle: DeepWorkStyle,
    val dayStartTime: LocalTime,
    val dayEndTime: LocalTime,
    val deepWorkStartTime: LocalTime,
    val deepWorkEndTime: LocalTime,
    val breakDuration: Int,
    val weekStartDay: DayOfWeek = DayOfWeek.MONDAY,
    val currentStreak: Int,
    val longestStreak: Int,
    val lastDeepWorkSession: LocalTime? = null
)
