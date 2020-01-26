package com.logrev.subjectservice.sevice

import com.logrev.subjectservice.domain.*
import com.logrev.subjectservice.repository.user.UserEntity
import com.logrev.subjectservice.repository.user.UserRepository
import com.logrev.subjectservice.security.*
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm.*
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class AuthService(private val userRepository: UserRepository,
                  private val userService: UserService) {

    @Throws(UsernameNotFoundException::class)
    fun login(model: LoginRequestModel): TokenResponseModel {
        userService.loadUserByUsername(model.username)?.let {
            if (BCrypt.checkpw(model.password, it.password)) {
                return TokenResponseModel(
                        generateToken(it.getId(), it.username, it.getRole()) ?: "",
                        LocalDateTime.now().plusSeconds(ACCESS_TOKEN_LIFETIME_SECONDS),
                        it.getRole()
                )
            }
        }
        throw UsernameNotFoundException("User with name: ${model.username} not found")
    }

    fun addUser(model: RegisterRequestModel) {
        userRepository.save(model.toUserEntity())
    }

    private fun generateToken(userId: UUID, username: String, role: Role): String? {
        return Jwts
                .builder()
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET.toByteArray()), HS256)
                .setHeaderParam(TOKEN_TYPE_HEADER, TOKEN_TYPE)
                .setIssuer(TOKEN_ISSUER)
                .setAudience(TOKEN_AUDIENCE)
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + ACCESS_TOKEN_LIFETIME_SECONDS * 1000))
                .claim(ROLE_CLAIM, role.toString())
                .claim(USER_ID_CLAIM, userId)
                .compact()
    }

    private fun RegisterRequestModel.toUserEntity() =
            UserEntity(username, BCrypt.hashpw(password, BCrypt.gensalt(12)), role)
}
