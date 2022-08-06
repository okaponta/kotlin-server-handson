/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.email
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.id
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.name
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.password
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.roleType
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.user
import com.book.manager.infrastructure.database.record.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface UserMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UserResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        Result(column="role_type", property="roleType", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<User>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UserResult")
    fun selectOne(selectStatement: SelectStatementProvider): User?
}

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, user, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, user, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun UserMapper.insert(row: User) =
    insert(this::insert, row, user) {
        map(id) toProperty "id"
        map(email) toProperty "email"
        map(password) toProperty "password"
        map(name) toProperty "name"
        map(roleType) toProperty "roleType"
    }

fun UserMapper.insertMultiple(records: Collection<User>) =
    insertMultiple(this::insertMultiple, records, user) {
        map(id) toProperty "id"
        map(email) toProperty "email"
        map(password) toProperty "password"
        map(name) toProperty "name"
        map(roleType) toProperty "roleType"
    }

fun UserMapper.insertMultiple(vararg records: User) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(row: User) =
    insert(this::insert, row, user) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(email).toPropertyWhenPresent("email", row::email)
        map(password).toPropertyWhenPresent("password", row::password)
        map(name).toPropertyWhenPresent("name", row::name)
        map(roleType).toPropertyWhenPresent("roleType", row::roleType)
    }

private val columnList = listOf(id, email, password, name, roleType)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, user, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, user, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, user, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, user, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: User) =
    apply {
        set(id) equalToOrNull row::id
        set(email) equalToOrNull row::email
        set(password) equalToOrNull row::password
        set(name) equalToOrNull row::name
        set(roleType) equalToOrNull row::roleType
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: User) =
    apply {
        set(id) equalToWhenPresent row::id
        set(email) equalToWhenPresent row::email
        set(password) equalToWhenPresent row::password
        set(name) equalToWhenPresent row::name
        set(roleType) equalToWhenPresent row::roleType
    }

fun UserMapper.updateByPrimaryKey(row: User) =
    update {
        set(email) equalToOrNull row::email
        set(password) equalToOrNull row::password
        set(name) equalToOrNull row::name
        set(roleType) equalToOrNull row::roleType
        where { id isEqualTo row.id!! }
    }

fun UserMapper.updateByPrimaryKeySelective(row: User) =
    update {
        set(email) equalToWhenPresent row::email
        set(password) equalToWhenPresent row::password
        set(name) equalToWhenPresent row::name
        set(roleType) equalToWhenPresent row::roleType
        where { id isEqualTo row.id!! }
    }