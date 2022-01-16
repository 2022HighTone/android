package com.iamgonna.android.main.model

import com.iamgonna.android.setSchool.model.SearchSchoolResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MainService {
    @GET("api/school/default-school/")
    suspend fun getLocation(
        @Header("Authorization") token : String
    ): Response<ResultSchool>
    @GET("api/school/search-school/")
    suspend fun searchSchool(
        @Query("name") name : String
    ): Response<SearchSchoolResponse>
    @GET("api/school/result-school/")
    suspend fun resultSchool(
        @Query("name") name : String,
        @Query("address") address : String,
        @Query("price") price : Int = 0,
        @Query("categories") categories : String = "a,b",
        @Query("distance") distance : String = "100m"
    ): Response<ResultSchool>
}