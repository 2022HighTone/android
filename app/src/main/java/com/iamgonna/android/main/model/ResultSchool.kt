package com.iamgonna.android.main.model

data class ResultSchool(
    val address: String,
    val id: Int,
    val is_default: Boolean,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val stores: List<Store>
)