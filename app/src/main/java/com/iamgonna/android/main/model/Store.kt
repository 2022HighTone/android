package com.iamgonna.android.main.model

data class Store(
    val address: String,
    val category: Int,
    val category_name: String,
    val distance: Int,
    val distance_name: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val menus: List<Menu>,
    val name: String,
    val school: Int,
    val school_name: String
)