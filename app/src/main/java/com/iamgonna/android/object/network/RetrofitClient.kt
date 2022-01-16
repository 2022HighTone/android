package com.iamgonna.android.`object`.network

import com.iamgonna.android.login.model.LoginService
import com.iamgonna.android.main.model.MainService
import com.iamgonna.android.setSchool.model.SetSchoolService
import com.iamgonna.android.signUp.model.SignUpService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofitBuild: Retrofit = Retrofit.Builder()
        .baseUrl("http://ec2-13-125-229-204.ap-northeast-2.compute.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val login : LoginService = retrofitBuild.create(LoginService::class.java)
    val signUp : SignUpService = retrofitBuild.create(SignUpService::class.java)
    val defaultLocation : MainService = retrofitBuild.create(MainService::class.java)
    val searchSchool : SetSchoolService = retrofitBuild.create(SetSchoolService::class.java)
    companion object {
        val instance = RetrofitClient()
    }
}