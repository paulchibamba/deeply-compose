package com.paulchibamba.deeply.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "project")
data class Project(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String?,
    val startDateMillis: Long,
    val endDateMillis: Long?,
    val status: Int // 0: ACTIVE, 1: COMPLETED, 2: ON_HOLD, 3: ARCHIVED
)
