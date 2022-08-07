package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.User

interface UserRepository {
    fun find(email: String): User?
}
