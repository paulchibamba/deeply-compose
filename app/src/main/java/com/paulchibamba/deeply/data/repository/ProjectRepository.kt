package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.ProjectDAO
import com.paulchibamba.deeply.model.Project
import com.paulchibamba.deeply.model.ProjectStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProjectRepository @Inject constructor(private val projectDAO: ProjectDAO) {

    val allProjects = projectDAO.getAll()

    fun getProject(id: Long): Flow<Project> {
        return projectDAO.getProject(id)
    }

    fun getByStatus(status: Int): Flow<List<Project>> {
        return projectDAO.getProjectsByStatus(status)
    }

    suspend fun add(project: Project) {
        projectDAO.addProject(project)
    }

    suspend fun update(project: Project) {
        projectDAO.updateProject(project)
    }

    suspend fun delete(project: Project) {
        projectDAO.deleteProject(project)
    }

    suspend fun deleteAll() {
        projectDAO.deleteAll()
    }

}