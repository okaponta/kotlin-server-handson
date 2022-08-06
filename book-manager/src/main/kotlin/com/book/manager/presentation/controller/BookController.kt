package com.book.manager.presentation.controller

import com.book.manager.presentation.response.BookInfo
import com.book.manager.presentation.response.GetBookListResponse
import com.book.manager.service.BookService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
@CrossOrigin
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map { BookInfo(it) }
        return GetBookListResponse(bookList)
    }
}
