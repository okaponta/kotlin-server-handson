package com.book.manager.presentation.request

import java.time.LocalDate

data class UpdateBookRequest(
    val id: Long,
    val title: String?,
    val author: String?,
    val releaseDate: LocalDate?
)
