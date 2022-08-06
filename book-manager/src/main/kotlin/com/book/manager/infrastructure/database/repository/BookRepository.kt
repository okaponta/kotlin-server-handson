package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.BookWithRental

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>
    fun findWithRental(id: Long): BookWithRental?
}
