package com.logrev.subjectservice.sevice

import com.logrev.subjectservice.domain.UserModel
import com.logrev.subjectservice.repository.user.UserEntity
import com.logrev.subjectservice.repository.user.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?) =
            userRepository.findByUsername(username ?: "")?.toUserModel()

    fun UserEntity.toUserModel() = UserModel(id, username, password, role)
}