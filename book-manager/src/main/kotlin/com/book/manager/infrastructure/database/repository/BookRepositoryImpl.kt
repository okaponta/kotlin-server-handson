package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.model.Rental
import com.book.manager.infrastructure.database.mapper.*
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class BookRepositoryImpl(
    private val bookWithRentalMapper: BookWithRentalMapper,
    private val bookMapper: BookMapper
) : BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select {}.map { toModel(it) }
    }

    override fun findWithRental(id: Long): BookWithRental? {
        return bookWithRentalMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    override fun register(book: Book) {
        bookMapper.insert(toRecord(book))
    }

    override fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
        bookMapper.updateByPrimaryKeySelective(
            com.book.manager.infrastructure.database.record.Book(
                id,
                title,
                author,
                releaseDate
            )
        )
    }

    override fun delete(id: Long) {
        bookMapper.deleteByPrimaryKey(id)
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

    private fun toRecord(model: Book): com.book.manager.infrastructure.database.record.Book {
        return com.book.manager.infrastructure.database.record.Book(
            model.id,
            model.title,
            model.author,
            model.releaseDate
        )
    }
}
