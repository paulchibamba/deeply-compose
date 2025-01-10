package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.Project
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectDAO {
    @Query("SELECT * FROM project")
    fun getAll(): Flow<List<Project>>

    @Query("SELECT * FROM project WHERE id = :id")
    fun getProject(id: Int): Flow<Project>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProject(project: Project)

    @Update
    suspend fun updateProject(project: Project)

    @Delete
    suspend fun deleteProject(project: Project)

    @Query("DELETE FROM project")
    suspend fun deleteAll()

    @Query("SELECT * FROM project WHERE status = :status")
    fun getProjectsByStatus(status: String): Flow<List<Project>>
}