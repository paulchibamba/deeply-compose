package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDAO {
    @Query("SELECT * FROM habit")
    fun getAll(): Flow<List<Habit>>

    @Query("SELECT * FROM habit WHERE id = :id")
    fun getHabit(id: Long): Flow<Habit>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query("DELETE FROM habit")
    suspend fun deleteAllHabits()

    @Query("SELECT * FROM habit WHERE name LIKE :query OR description LIKE :query")
    fun searchHabits(query: String): Flow<List<Habit>>

}