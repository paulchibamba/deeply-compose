package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val deepWorkStyle: Int, // 0: MONASTIC, 1: BIMODAL, 2: RHYTHMIC, 3: JOURNALISTIC
    val dayStartMillis: Long,
    val dayEndMillis: Long,
    val deepWorkStartMillis: Long,
    val deepWorkEndMillis: Long,
    val breakDurationMillis: Long,
    val weekStartDay: Int, // 1-7 for Monday-Sunday
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastDeepWorkMillis: Long?
)
