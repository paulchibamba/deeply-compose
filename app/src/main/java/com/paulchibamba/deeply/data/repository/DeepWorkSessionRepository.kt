package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.DeepWorkSessionDAO
import com.paulchibamba.deeply.model.DeepWorkSession
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class DeepWorkSessionRepository @Inject constructor(private val deepWorkSessionDAO: DeepWorkSessionDAO) {
    val allSessions: Flow<List<DeepWorkSession>> = deepWorkSessionDAO.getSessions()
    suspend fun add(session: DeepWorkSession) {
        deepWorkSessionDAO.addSession(session)
    }

    fun get(id: Long): Flow<DeepWorkSession> {
        return deepWorkSessionDAO.getSession(id)
    }

    fun getForToday(currentDate: LocalDateTime): Flow<List<DeepWorkSession>> {
        return deepWorkSessionDAO.getSessionsForToday(currentDate)
    }

    fun getByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<DeepWorkSession>> {
        return deepWorkSessionDAO.getSessionsByDateRange(startDate, endDate)
    }

    suspend fun update(session: DeepWorkSession) {
        deepWorkSessionDAO.updateSession(session)
    }

    suspend fun delete(session: DeepWorkSession) {
        deepWorkSessionDAO.deleteSession(session)
    }

    suspend fun deleteAll() {
        deepWorkSessionDAO.deleteAllSessions()
    }



}