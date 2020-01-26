package com.logrev.subjectservice.domain

import java.time.LocalDateTime

data class TokenResponseModel(
        val accessToken: String,
        val expirationDateTime: LocalDateTime,
        val role: Role
)