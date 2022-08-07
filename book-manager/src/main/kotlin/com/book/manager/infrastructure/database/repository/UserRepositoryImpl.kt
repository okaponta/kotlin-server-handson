package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.User
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport
import com.book.manager.infrastructure.database.mapper.UserMapper
import com.book.manager.infrastructure.database.mapper.selectOne
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UserMapper
) : UserRepository {
    override fun find(email: String): User? {
        val record = mapper.selectOne {
            where { UserDynamicSqlSupport.email isEqualTo email }
        }
        return record?.let { toModel(it) }
    }
    
    private fun toModel(record: com.book.manager.infrastructure.database.record.User): User {
        return User(
            record.id!!,
            record.email!!,
            record.password!!,
            record.name!!,
            record.roleType!!
        )
    }
}
