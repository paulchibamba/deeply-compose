package com.paulchibamba.deeply.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.paulchibamba.deeply.model.DailyJournal
import com.paulchibamba.deeply.model.EnergyLevel
import com.paulchibamba.deeply.model.Mood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface DailyJournalDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntry(entry: DailyJournal)

    @Query("SELECT * FROM daily_journal")
    fun getEntries(): Flow<List<DailyJournal>>

    @Query("SELECT * FROM daily_journal WHERE dateMillis = :date")
    fun getEntry(date: Long): Flow<DailyJournal>

    @Query("SELECT * FROM daily_journal WHERE mood = :mood")
    fun getEntriesByMood(mood: Mood): Flow<List<DailyJournal>>

    @Query("SELECT * FROM daily_journal WHERE energyLevel = :energyLevel")
    fun getEntriesByEnergyLevel(energyLevel: Int): Flow<List<DailyJournal>>

    @Update
    suspend fun updateEntry(entry: DailyJournal)

    @Delete
    suspend fun deleteEntry(entry: DailyJournal)

    @Query("DELETE FROM daily_journal")
    suspend fun deleteAllEntries()
}