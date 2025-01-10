package com.paulchibamba.deeply.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paulchibamba.deeply.data.local.dao.DailyJournalDAO
import com.paulchibamba.deeply.data.local.dao.DeepWorkSessionDAO
import com.paulchibamba.deeply.data.local.dao.GoalDAO
import com.paulchibamba.deeply.data.local.dao.HabitDAO
import com.paulchibamba.deeply.data.local.dao.ProjectDAO
import com.paulchibamba.deeply.data.local.dao.TaskDAO
import com.paulchibamba.deeply.data.local.dao.UserDAO
import com.paulchibamba.deeply.model.DailyJournal
import com.paulchibamba.deeply.model.DeepWorkSession
import com.paulchibamba.deeply.model.Goal
import com.paulchibamba.deeply.model.Habit
import com.paulchibamba.deeply.model.Project
import com.paulchibamba.deeply.model.Task
import com.paulchibamba.deeply.model.User
import com.paulchibamba.deeply.model.WeeklyReview

@Database(entities = [DailyJournal::class, DeepWorkSession::class, Goal::class, Habit::class, Project::class, Task::class, User::class, WeeklyReview::class], version = 1, exportSchema = false)
abstract class DeeplyDatabase: RoomDatabase() {
    abstract fun dailyJournalDao(): DailyJournalDAO
    abstract fun deepWorkSessionDao(): DeepWorkSessionDAO
    abstract fun goalDao(): GoalDAO
    abstract fun habitDao(): HabitDAO
    abstract fun projectDao(): ProjectDAO
    abstract fun taskDao(): TaskDAO
    abstract fun userDao(): UserDAO
}