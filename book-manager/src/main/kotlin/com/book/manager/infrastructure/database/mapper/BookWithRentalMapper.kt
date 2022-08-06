package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.author
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.book
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.id
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.releaseDate
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.title
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rental
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.returnDeadline
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.userId
import com.book.manager.infrastructure.database.record.BookWithRental
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface BookWithRentalMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<BookWithRental>,
    CommonUpdateMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "BookResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
            Result(column = "release_date", property = "releaseDate", jdbcType = JdbcType.DATE),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "rental_datetime", property = "rentalDatetime", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "return_deadline", property = "returnDeadline", jdbcType = JdbcType.TIMESTAMP)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<BookWithRental>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("BookResult")
    fun selectOne(selectStatement: SelectStatementProvider): BookWithRental?
}

private val columnList = listOf(
    id,
    title,
    author,
    releaseDate,
    userId,
    rentalDatetime,
    returnDeadline
)

fun BookWithRentalMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, book, completer)

fun BookWithRentalMapper.select(completer: SelectCompleter) =
    org.mybatis.dynamic.sql.util.kotlin.mybatis3.select(columnList) {
        from(book)
        leftJoin(rental) {
            on(rental.bookId) equalTo book.id
        }
        completer()
    }.run(this::selectMany)
