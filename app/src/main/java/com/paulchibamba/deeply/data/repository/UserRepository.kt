package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.UserDAO
import com.paulchibamba.deeply.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDAO: UserDAO) {
    fun getUser(): Flow<User> {
        return userDAO.getUser()
    }

    suspend fun add(user: User) {
        userDAO.addUser(user)
    }

    suspend fun update(user: User) {
        userDAO.updateUser(user)
    }

    suspend fun delete() {
        userDAO.deleteAllUsers()
    }
}