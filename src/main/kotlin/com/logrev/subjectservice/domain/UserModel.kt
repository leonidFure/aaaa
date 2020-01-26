package com.logrev.subjectservice.domain

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class UserModel(private var id: UUID = UUID.randomUUID(),
                private val username: String,
                private var password: String,
                private val role: Role)
    : UserDetails {

    constructor(username: String, password: String, role: Role): this(UUID.randomUUID(), username, password, role)

    fun setPassword(password: String) {
        this.password = password
    }

    fun setId(id: UUID) {
        this.id = id
    }

    fun getId() = id

    fun getRole() = role

    override fun getAuthorities() = mutableListOf(SimpleGrantedAuthority(role.toString()))

    override fun isEnabled() = true

    override fun getUsername() = username

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

}