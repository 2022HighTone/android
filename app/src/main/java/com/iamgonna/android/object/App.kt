package com.iamgonna.android.`object`

import android.app.Application
import com.iamgonna.android.PreferenceUtil

class App : Application() {
    companion object
    {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate()
    {
        super.onCreate()
        prefs = PreferenceUtil(applicationContext)
    }
}