/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.demo.database

import com.example.demo.database.UserDynamicSqlSupport.age
import com.example.demo.database.UserDynamicSqlSupport.id
import com.example.demo.database.UserDynamicSqlSupport.name
import com.example.demo.database.UserDynamicSqlSupport.profile
import com.example.demo.database.UserDynamicSqlSupport.user
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface UserMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "UserResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            Result(column = "profile", property = "profile", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<User>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("UserResult")
    fun selectOne(selectStatement: SelectStatementProvider): User?
}

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, user, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, user, completer)

fun UserMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where { id isEqualTo id_ }
    }

fun UserMapper.insert(row: User) =
    insert(this::insert, row, user) {
        map(id) toProperty "id"
        map(name) toProperty "name"
        map(age) toProperty "age"
        map(profile) toProperty "profile"
    }

fun UserMapper.insertMultiple(records: Collection<User>) =
    insertMultiple(this::insertMultiple, records, user) {
        map(id) toProperty "id"
        map(name) toProperty "name"
        map(age) toProperty "age"
        map(profile) toProperty "profile"
    }

fun UserMapper.insertMultiple(vararg records: User) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(row: User) =
    insert(this::insert, row, user) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(name).toPropertyWhenPresent("name", row::name)
        map(age).toPropertyWhenPresent("age", row::age)
        map(profile).toPropertyWhenPresent("profile", row::profile)
    }

private val columnList = listOf(id, name, age, profile)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, user, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, user, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, user, completer)

fun UserMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, user, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: User) =
    apply {
        set(id) equalToOrNull row::id
        set(name) equalToOrNull row::name
        set(age) equalToOrNull row::age
        set(profile) equalToOrNull row::profile
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: User) =
    apply {
        set(id) equalToWhenPresent row::id
        set(name) equalToWhenPresent row::name
        set(age) equalToWhenPresent row::age
        set(profile) equalToWhenPresent row::profile
    }

fun UserMapper.updateByPrimaryKey(row: User) =
    update {
        set(name) equalToOrNull row::name
        set(age) equalToOrNull row::age
        set(profile) equalToOrNull row::profile
        where { id isEqualTo row.id!! }
    }

fun UserMapper.updateByPrimaryKeySelective(row: User) =
    update {
        set(name) equalToWhenPresent row::name
        set(age) equalToWhenPresent row::age
        set(profile) equalToWhenPresent row::profile
        where { id isEqualTo row.id!! }
    }
