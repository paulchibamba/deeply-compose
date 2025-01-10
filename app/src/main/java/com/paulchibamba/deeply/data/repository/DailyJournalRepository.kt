package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.DailyJournalDAO
import com.paulchibamba.deeply.model.DailyJournal
import com.paulchibamba.deeply.model.EnergyLevel
import com.paulchibamba.deeply.model.Mood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class DailyJournalRepository @Inject constructor(private val dailyJournalDao: DailyJournalDAO) {

    val getAllEntries: Flow<List<DailyJournal>> = dailyJournalDao.getEntries()

    fun getEntryDate(date: LocalDate): Flow<DailyJournal> {
        return dailyJournalDao.getEntry(date)
    }

    fun getEntriesByMood(mood: Mood): Flow<List<DailyJournal>> {
        return dailyJournalDao.getEntriesByMood(mood)
    }

    fun getEntriesByEnergyLevel(energyLevel: EnergyLevel): Flow<List<DailyJournal>> {
        return dailyJournalDao.getEntriesByEnergyLevel(energyLevel)
    }

    suspend fun addEntry(dailyJournal: DailyJournal) {
        dailyJournalDao.addEntry(dailyJournal)
    }

    suspend fun updateDailyJournal(dailyJournal: DailyJournal) {
        dailyJournalDao.updateEntry(dailyJournal)
    }

    suspend fun deleteDailyJournal(dailyJournal: DailyJournal) {
        dailyJournalDao.deleteEntry(dailyJournal)
    }

    suspend fun deleteAllEntries() {
        dailyJournalDao.deleteAllEntries()
    }

}