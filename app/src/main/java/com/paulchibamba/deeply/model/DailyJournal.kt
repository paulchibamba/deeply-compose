package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "daily_journal")
data class DailyJournal(
    @PrimaryKey val date: LocalDate,
    val reflections: String,
    val distractions: List<String>,
    val improvements: String,
    val deepWorkHours: Float,
    val shallowWorkHours: Float,
    val mood: Mood,
    val energyLevel: EnergyLevel,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
