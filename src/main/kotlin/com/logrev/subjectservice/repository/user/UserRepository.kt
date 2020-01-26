package com.logrev.subjectservice.repository.user

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<UserEntity, UUID>{
    fun findByUsername(username: String): UserEntity?
}