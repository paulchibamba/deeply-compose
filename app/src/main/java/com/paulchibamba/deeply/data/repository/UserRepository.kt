package com.paulchibamba.deeply.data.repository

import com.paulchibamba.deeply.data.local.dao.UserDAO
import com.paulchibamba.deeply.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDAO: UserDAO) {
    fun getUser(): Flow<User> {
        return userDAO.getUser()
    }

    suspend fun addUser(user: User) {
        userDAO.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDAO.updateUser(user)
    }

    suspend fun deleteUsers() {
        userDAO.deleteAllUsers()
    }
}