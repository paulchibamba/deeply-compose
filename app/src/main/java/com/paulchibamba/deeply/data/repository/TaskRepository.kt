package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.TaskDAO
import com.paulchibamba.deeply.data.local.dao.UserDAO
import com.paulchibamba.deeply.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TaskRepository @Inject constructor(private val taskDao: TaskDAO) {

    val allTasks: Flow<List<Task>> = taskDao.getAllTasks()
    val sortByHighPriority: Flow<List<Task>> = taskDao.sortByHighPriority()
    val sortByLowPriority: Flow<List<Task>> = taskDao.sortByLowPriority()

    fun getTask(taskId: Long): Flow<Task> {
        return taskDao.getTaskById(taskId)
    }

    suspend fun add(task: Task) {
        taskDao.addTask(task)
    }

    suspend fun update(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun delete(task: Task) {
        taskDao.deleteTask(task)
    }

    suspend fun deleteAll() {
        taskDao.deleteAllTasks()
    }

    fun search(query: String): Flow<List<Task>> {
        return taskDao.searchTasks(query)
    }
}