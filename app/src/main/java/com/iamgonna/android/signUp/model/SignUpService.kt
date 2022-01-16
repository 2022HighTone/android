package com.iamgonna.android.signUp.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("api/auth/sign-up/")
    suspend fun signUp(
        @Body signUpRequest : SignUpRequest
    ): Response<SignUpResponse>
}