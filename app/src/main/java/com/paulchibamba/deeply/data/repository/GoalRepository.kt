package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.GoalDAO
import com.paulchibamba.deeply.model.Goal
import com.paulchibamba.deeply.model.GoalType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GoalRepository @Inject constructor(private val goalDao: GoalDAO) {
    val allGoals: Flow<List<Goal>> = goalDao.getAll()
    val goalCount: Flow<Int> = goalDao.getGoalCount()

    fun getGoal(id: Long): Flow<Goal> {
        return goalDao.getGoal(id)
    }

    fun getByTypeId(goalType: GoalType): Flow<List<Goal>> {
        return goalDao.getGoalsByType(goalType)
    }
    suspend fun add(goal: Goal) {
        goalDao.addGoal(goal)
    }

    suspend fun update(goal: Goal) {
        goalDao.updateGoal(goal)
    }

    suspend fun delete(goal: Goal) {
        goalDao.deleteGoal(goal)
    }

    suspend fun deleteAll() {
        goalDao.deleteAllGoals()
    }

    fun search(query: String): Flow<List<Goal>> {
        return goalDao.searchGoals(query)
    }

}