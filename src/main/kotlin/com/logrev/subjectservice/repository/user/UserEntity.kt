package com.logrev.subjectservice.repository.user

import com.logrev.subjectservice.domain.Role
import java.util.*
import javax.persistence.*
@Entity
@Table(name = "usr")
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "_id")
        val id: UUID,
        @Column(name = "username", unique = true)
        val username: String,
        @Column(name = "password")
        val password: String,
        @Column(name = "is_active")
        val isActive: Boolean,
        @Column(name = "role")
        @Enumerated(value = EnumType.STRING)
        val role: Role
) {
        constructor(username: String, password: String, role: Role) : this(UUID.randomUUID(), username, password, true, role)
}