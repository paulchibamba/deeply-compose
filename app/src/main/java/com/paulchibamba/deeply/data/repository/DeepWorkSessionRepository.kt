package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.DeepWorkSessionDAO
import com.paulchibamba.deeply.model.DeepWorkSession
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class DeepWorkSessionRepository @Inject constructor(private val deepWorkSessionDAO: DeepWorkSessionDAO) {
    val sessions: Flow<List<DeepWorkSession>> = deepWorkSessionDAO.getSessions()
    suspend fun addSession(session: DeepWorkSession) {
        deepWorkSessionDAO.addSession(session)
    }

    fun getSession(id: Long): Flow<DeepWorkSession> {
        return deepWorkSessionDAO.getSession(id)
    }

    fun getSessionsForToday(currentDate: LocalDateTime): Flow<List<DeepWorkSession>> {
        return deepWorkSessionDAO.getSessionsForToday(currentDate)
    }

    fun getSessionsByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<DeepWorkSession>> {
        return deepWorkSessionDAO.getSessionsByDateRange(startDate, endDate)
    }

    suspend fun updateSession(session: DeepWorkSession) {
        deepWorkSessionDAO.updateSession(session)
    }

    suspend fun deleteSession(session: DeepWorkSession) {
        deepWorkSessionDAO.deleteSession(session)
    }

    suspend fun deleteAllSessions() {
        deepWorkSessionDAO.deleteAllSessions()
    }



}