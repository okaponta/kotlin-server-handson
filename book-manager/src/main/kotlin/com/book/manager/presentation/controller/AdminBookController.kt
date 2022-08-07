package com.book.manager.presentation.controller

import com.book.manager.domain.model.Book
import com.book.manager.presentation.request.RegisterBookRequest
import com.book.manager.presentation.request.UpdateBookRequest
import com.book.manager.service.AdminBookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin/book")
class AdminBookController(
    private val adminBookService: AdminBookService
) {
    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterBookRequest
    ) {
        adminBookService.register(
            Book(
                request.id,
                request.title,
                request.author,
                request.releaseDate
            )
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateBookRequest) {
        adminBookService.update(request.id, request.title, request.author, request.releaseDate)
    }

    @DeleteMapping("/delete/{book_id}")
    fun delete(@PathVariable("book_id") bookId: Long) {
        adminBookService.delete(bookId)
    }
}
