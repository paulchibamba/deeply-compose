package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.HabitDAO
import com.paulchibamba.deeply.model.Habit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HabitRepository @Inject constructor(private val habitDAO: HabitDAO){
    val allHabits = habitDAO.getAll()

    fun getHabit(id: Long): Flow<Habit> {
        return habitDAO.getHabit(id)
    }
    suspend fun addHabit(habit: Habit){
        habitDAO.addHabit(habit)
    }

    suspend fun updateHabit(habit: Habit){
        habitDAO.updateHabit(habit)
    }

    suspend fun deleteHabit(habit: Habit){
        habitDAO.deleteHabit(habit)
    }

    suspend fun deleteAllHabits(){
        habitDAO.deleteAllHabits()
    }

    fun searchHabits(query: String): Flow<List<Habit>> {
        return habitDAO.searchHabits(query)
    }
}