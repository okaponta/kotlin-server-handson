package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Rental
import com.book.manager.infrastructure.database.mapper.RentalMapper
import com.book.manager.infrastructure.database.mapper.deleteByPrimaryKey
import com.book.manager.infrastructure.database.mapper.insert
import org.springframework.stereotype.Repository

@Repository
class RentalRepositoryImpl(
    private val rentalMapper: RentalMapper
) : RentalRepository {
    override fun startRental(rental: Rental) {
        rentalMapper.insert(toRecord(rental))
    }

    override fun endRental(bookId: Long) {
        rentalMapper.deleteByPrimaryKey(bookId)
    }

    private fun toRecord(model: Rental): com.book.manager.infrastructure.database.record.Rental {
        return com.book.manager.infrastructure.database.record.Rental(
            model.bookId,
            model.userId,
            model.rentalDatetime,
            model.returnDeadline
        )
    }
}
