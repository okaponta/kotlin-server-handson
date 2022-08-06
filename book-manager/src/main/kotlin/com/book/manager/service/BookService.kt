package com.book.manager.service

import com.book.manager.domain.model.BookWithRental
import com.book.manager.infrastructure.database.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }

    fun getDetail(bookId: Long): BookWithRental {
        return bookRepository.findWithRental(bookId)
            ?: throw java.lang.IllegalArgumentException("存在しない書籍ID: $bookId")
    }
}
