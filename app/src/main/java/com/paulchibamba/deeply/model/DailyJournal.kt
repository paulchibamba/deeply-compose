package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "daily_journal")
data class DailyJournal(
    @PrimaryKey val dateMillis: Long,
    val reflection: String,
    val distractions: String?, //comma-separated "distraction1,distraction2,distraction3"
    val improvements: String,
    val deepWorkHours: Float,
    val shallowWorkHours: Float,
    val mood: Int, // 0: EXCELLENT, 1: GOOD, 2: NEUTRAL, 3: POOR, 4: BAD
    val energyLevel: Int, // 0: HIGH, 1: MEDIUM, 2: LOW
    val createdAtMillis: Long
)
