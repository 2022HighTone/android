package com.iamgonna.android.setSchool.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SetSchoolService {
    @GET("api/school/search-school/")
    suspend fun searchSchool(
        @Query("name") name : String
    ): Response<SearchSchoolResponse>
}