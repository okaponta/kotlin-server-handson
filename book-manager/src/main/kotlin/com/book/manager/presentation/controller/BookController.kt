package com.book.manager.presentation.controller

import com.book.manager.presentation.response.BookInfo
import com.book.manager.presentation.response.GetBookDetailResponse
import com.book.manager.presentation.response.GetBookListResponse
import com.book.manager.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map { BookInfo(it) }
        return GetBookListResponse(bookList)
    }

    @GetMapping("/detail/{book_id}")
    fun getDetail(
        @PathVariable("book_id") bookId: Long
    ): GetBookDetailResponse {
        val book = bookService.getDetail(bookId)
        return GetBookDetailResponse(book)
    }
}
