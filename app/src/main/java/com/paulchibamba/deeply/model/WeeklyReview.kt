package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "weekly_review")
data class WeeklyReview(
    @PrimaryKey val weekStartMillis: Long,
    val weekEndMillis: Long,
    val accomplishments: String?, //comma-separated "accomplishment1,accomplishment2"
    val challenges: String?,      //comma-separated "challenge1,challenge2"
    val nextWeekGoals: String?,  //comma-separated "goal1,goal2"
    val totalDeepWorkHours: Float,
    val totalShallowWorkHours: Float,
    val completedTasksCount: Int,
    val missedTasksCount: Int
)