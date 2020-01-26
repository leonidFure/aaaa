package com.logrev.subjectservice.security

const val TOKEN_HEADER = "Authorization"
const val TOKEN_PREFIX = "Bearer "
const val TOKEN_TYPE_HEADER = "typ"
const val TOKEN_TYPE = "JWT"
const val TOKEN_ISSUER = "secure-api"
const val TOKEN_AUDIENCE = "secure-app"
const val ACCESS_TOKEN_LIFETIME_SECONDS = 24 * 60 * 60L
const val JWT_SECRET = "twPKMp7sEI6idj8FGSm2HjHEiZ6wPCVN5DgXHOFREUQhVqHRYAYvfh"
const val ROLE_CLAIM = "role"
const val USER_ID_CLAIM = "userId"