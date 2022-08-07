package com.book.manager.presentation.controller

import com.book.manager.presentation.request.RentalStartRequest
import com.book.manager.service.RentalService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("rental")
class RentalController(
    private val rentalService: RentalService
) {
    @PostMapping("/start")
    fun startRental(
        @RequestBody request: RentalStartRequest
    ) {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetails
        rentalService.startRental(request.bookId, user.username)
    }

    @DeleteMapping("/end/{book_id}")
    fun endRental(
        @PathVariable("book_id") bookId: Long
    ) {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetails
        rentalService.endRental(bookId, user.username)
    }
}
