package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val goalDuration: Int,
    val startDate: Long,
    val endDate: Long,
    val isActive: Boolean,
    val priority: Priority
)
