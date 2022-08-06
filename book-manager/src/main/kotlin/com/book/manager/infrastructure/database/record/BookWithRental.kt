package com.book.manager.infrastructure.database.record

import java.time.LocalDate
import java.time.LocalDateTime

class BookWithRental(
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
)
