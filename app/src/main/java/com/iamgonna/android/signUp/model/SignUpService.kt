package com.iamgonna.android.signUp.model

import com.iamgonna.android.login.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("/auth/sign-up/")
    suspend fun signUp(
        @Body signUpRequest : SignUpRequest
    ): Response<SignUpResponse>
}