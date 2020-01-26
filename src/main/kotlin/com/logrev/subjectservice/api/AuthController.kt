package com.logrev.subjectservice.api

import com.logrev.subjectservice.domain.LoginRequestModel
import com.logrev.subjectservice.domain.RegisterRequestModel
import com.logrev.subjectservice.domain.UserModel
import com.logrev.subjectservice.sevice.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import javax.annotation.security.PermitAll

@RestController
@RequestMapping("api/auth")
class AuthController(val authService: AuthService) {

    @PostMapping("login")
    @PermitAll
    fun login(@RequestBody model: LoginRequestModel) =
            ok(authService.login(model))

    @PostMapping("register")
    @PermitAll
    fun register(@RequestBody model: RegisterRequestModel) =
            ok(authService.addUser(model))
}