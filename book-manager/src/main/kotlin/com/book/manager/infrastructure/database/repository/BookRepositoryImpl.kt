package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.model.Rental
import com.book.manager.infrastructure.database.mapper.BookWithRentalMapper
import com.book.manager.infrastructure.database.mapper.select
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper
) : BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select {}.map { toModel(it) }
    }

    private fun toModel(record: com.book.manager.infrastructure.database.record.BookWithRental): BookWithRental {
        val book = Book(
            record.id!!,
            record.title!!,
            record.author!!,
            record.releaseDate!!
        )
        val rental = record.userId?.let {
            Rental(
                record.id!!,
                record.userId!!,
                record.rentalDatetime!!,
                record.returnDeadline!!
            )
        }
        return BookWithRental(book, rental)
    }
}
