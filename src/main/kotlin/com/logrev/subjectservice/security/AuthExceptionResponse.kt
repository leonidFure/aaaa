package com.logrev.subjectservice.security

import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
class AuthExceptionResponse(message: String?) : AuthenticationException(message)