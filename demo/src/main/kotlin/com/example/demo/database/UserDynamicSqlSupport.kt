/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.demo.database

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object UserDynamicSqlSupport {
    val user = User()

    val id = user.id

    val name = user.name

    val age = user.age

    val profile = user.profile

    class User : AliasableSqlTable<User>("user", UserDynamicSqlSupport::User) {
        val id = column<Int>(name = "id", jdbcType = JDBCType.INTEGER)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val age = column<Int>(name = "age", jdbcType = JDBCType.INTEGER)

        val profile = column<String>(name = "profile", jdbcType = JDBCType.VARCHAR)
    }
}
