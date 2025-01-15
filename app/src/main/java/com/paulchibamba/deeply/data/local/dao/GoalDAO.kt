package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.Goal
import com.paulchibamba.deeply.model.GoalType
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGoal(goal: Goal)

    @Query("SELECT * FROM Goal")
    fun getAll(): Flow<List<Goal>>

    @Query("SELECT * FROM Goal WHERE id = :id")
    fun getGoal(id: Long): Flow<Goal>

    @Query("SELECT * FROM Goal WHERE type = :type")
    fun getGoalsByType(type: Int): Flow<List<Goal>>

    @Query("SELECT COUNT(*) FROM Goal")
    fun getGoalCount(): Flow<Int>

    @Update
    suspend fun updateGoal(goal: Goal)

    @Delete
    suspend fun deleteGoal(goal: Goal)

    @Query("DELETE FROM Goal")
    suspend fun deleteAllGoals()

    @Query("SELECT * FROM Goal WHERE title LIKE :query OR description LIKE :query OR type LIKE :query")
    fun searchGoals(query: String): Flow<List<Goal>>

}