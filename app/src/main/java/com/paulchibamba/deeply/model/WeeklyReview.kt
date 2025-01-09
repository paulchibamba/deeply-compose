package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "weekly_review")
data class WeeklyReview(
    @PrimaryKey val weekStartDate: LocalDate,
    val weekEndDate: LocalDate,
    val accomplishments: List<String>,
    val challenges: List<String>,
    val nextWeekGoals: List<String>,
    val totalDeepWorkHours: Float,
    val totalShallowWorkHours: Float,
    val completedTaskCount: Int,
    val missedTaskCount: Int
)
