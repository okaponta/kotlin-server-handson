/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object RentalDynamicSqlSupport {
    val rental = Rental()

    val bookId = rental.bookId

    val userId = rental.userId

    val rentalDatetime = rental.rentalDatetime

    val returnDeadline = rental.returnDeadline

    class Rental : AliasableSqlTable<Rental>("rental", ::Rental) {
        val bookId = column<Long>(name = "book_id", jdbcType = JDBCType.BIGINT)

        val userId = column<Long>(name = "user_id", jdbcType = JDBCType.BIGINT)

        val rentalDatetime = column<LocalDateTime>(name = "rental_datetime", jdbcType = JDBCType.TIMESTAMP)

        val returnDeadline = column<LocalDateTime>(name = "return_deadline", jdbcType = JDBCType.TIMESTAMP)
    }
}