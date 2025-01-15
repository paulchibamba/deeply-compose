package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.DeepWorkSession
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime


@Dao
interface DeepWorkSessionDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSession(deepWorkSession: DeepWorkSession)

    @Query("SELECT * FROM session ORDER BY id ASC")
    fun getSessions(): Flow<List<DeepWorkSession>>

    @Query("SELECT * FROM session WHERE id = :id")
    fun getSession(id: Long): Flow<DeepWorkSession>

    @Query("SELECT * FROM session WHERE DATE(startTimeMillis) = DATE(:currentDate)")
    fun getSessionsForToday(currentDate: Long): Flow<List<DeepWorkSession>>

    @Query("SELECT * FROM session WHERE DATE(startTimeMillis) BETWEEN DATE(:startDate) AND DATE(:endDate)")
    fun getSessionsByDateRange(startDate: Long, endDate: Long): Flow<List<DeepWorkSession>>

    @Update
    suspend fun updateSession(deepWorkSession: DeepWorkSession)

    @Delete
    suspend fun deleteSession(deepWorkSession: DeepWorkSession)

    @Query("DELETE FROM session")
    suspend fun deleteAllSessions()

}