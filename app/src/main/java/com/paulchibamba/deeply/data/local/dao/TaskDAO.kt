package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Query("SELECT * FROM task ORDER BY id ASC")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM task WHERE id = :taskId")
    fun getTaskById(taskId: Long): Flow<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM task WHERE title LIKE :query OR description LIKE :query")
    fun searchTasks(query: String): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<Task>>

    @Query("SELECT COUNT(*) FROM task WHERE status = 'COMPLETED'")
    fun countCompletedTasks(): Flow<Int>

    @Query("SELECT * FROM task WHERE status = 'COMPLETED'")
    fun getCompletedTasks(): Flow<List<Task>>

    @Query("SELECT COUNT(*) FROM task WHERE status = 'MISSED'")
    fun countMissedTasks(): Flow<Int>

    @Query("SELECT * FROM task WHERE status = 'MISSED'")
    fun getMissedTasks(): Flow<List<Task>>

    @Query("SELECT COUNT(*) FROM task WHERE status = 'NOT_STARTED'")
    fun countTasksNotStarted(): Flow<Int>
    @Query("SELECT * FROM task WHERE status = 'NOT_STARTED'")
    fun getTasksNotStarted(): Flow<List<Task>>

}