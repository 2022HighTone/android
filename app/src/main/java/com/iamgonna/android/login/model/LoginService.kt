package com.iamgonna.android.login.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/auth/sign-in/")
    suspend fun login(
        @Body loginRequest : LoginRequest
    ): Response<LoginResponse>
}