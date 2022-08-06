package com.book.manager.presentation.controller

import com.book.manager.presentation.response.BookInfo
import com.book.manager.presentation.response.GetBookDetailResponse
import com.book.manager.presentation.response.GetBookListResponse
import com.book.manager.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
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
