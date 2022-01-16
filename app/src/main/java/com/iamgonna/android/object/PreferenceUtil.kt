package com.iamgonna.android.`object`

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context)
{
    private val prefs: SharedPreferences = context.getSharedPreferences("other", 0)

    fun getString(key: String, defValue: String): String
    {
        return prefs.getString(key, defValue).toString()
    }

    fun setString(key: String, str: String)
    {
        prefs.edit().putString(key, str).apply()
    }
    fun putLogin(key: String, str: String){
        prefs.edit().putString(key, str).apply()
    }
    fun getLogin(key: String, str: String) : String{
        return prefs.getString(key, str).toString()
    }
}