package com.book.manager.presentation.response

import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.model.Rental
import java.time.LocalDate
import java.time.LocalDateTime

data class GetBookDetailResponse(
    val id: Long,
    val title: String,
    val author: String,
    val releaseDate: LocalDate,
    val rentalInfo: RentalInfo?
) {
    constructor(model: BookWithRental) : this(
        model.book.id,
        model.book.title,
        model.book.author,
        model.book.releaseDate,
        model.rental?.let { RentalInfo(model.rental) }
    )
}

data class RentalInfo(
    val userId: Long,
    val rentalDatetime: LocalDateTime,
    val returnDeadline: LocalDateTime
) {
    constructor(rental: Rental) : this(
        rental.userId,
        rental.rentalDatetime,
        rental.returnDeadline
    )
}
