/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.domain.enum.RoleType
import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UserDynamicSqlSupport {
    val user = User()

    val id = user.id

    val email = user.email

    val password = user.password

    val name = user.name

    val roleType = user.roleType

    class User : AliasableSqlTable<User>("user", ::User) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val email = column<String>(name = "email", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val roleType = column<RoleType>(name = "role_type", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}