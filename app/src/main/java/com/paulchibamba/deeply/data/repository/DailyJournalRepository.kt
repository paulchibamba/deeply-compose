package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.DailyJournalDAO
import com.paulchibamba.deeply.model.DailyJournal
import com.paulchibamba.deeply.model.EnergyLevel
import com.paulchibamba.deeply.model.Mood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class DailyJournalRepository @Inject constructor(private val dailyJournalDao: DailyJournalDAO) {

    val allEntries: Flow<List<DailyJournal>> = dailyJournalDao.getEntries()

    fun get(date: LocalDate): Flow<DailyJournal> {
        return dailyJournalDao.getEntry(date)
    }

    fun getByMood(mood: Mood): Flow<List<DailyJournal>> {
        return dailyJournalDao.getEntriesByMood(mood)
    }

    fun getByEnergyLevel(energyLevel: EnergyLevel): Flow<List<DailyJournal>> {
        return dailyJournalDao.getEntriesByEnergyLevel(energyLevel)
    }

    suspend fun add(dailyJournal: DailyJournal) {
        dailyJournalDao.addEntry(dailyJournal)
    }

    suspend fun update(dailyJournal: DailyJournal) {
        dailyJournalDao.updateEntry(dailyJournal)
    }

    suspend fun delete(dailyJournal: DailyJournal) {
        dailyJournalDao.deleteEntry(dailyJournal)
    }

    suspend fun deleteAll() {
        dailyJournalDao.deleteAllEntries()
    }

}