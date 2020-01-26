package com.logrev.subjectservice.security

import java.util.*

data class TokenCredentialContainer(
        val userId: UUID,
        val jwt: String
)
