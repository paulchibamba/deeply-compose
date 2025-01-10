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
    suspend fun add(habit: Habit){
        habitDAO.addHabit(habit)
    }

    suspend fun update(habit: Habit){
        habitDAO.updateHabit(habit)
    }

    suspend fun delete(habit: Habit){
        habitDAO.deleteHabit(habit)
    }

    suspend fun deleteAll(){
        habitDAO.deleteAllHabits()
    }

    fun search(query: String): Flow<List<Habit>> {
        return habitDAO.searchHabits(query)
    }
}