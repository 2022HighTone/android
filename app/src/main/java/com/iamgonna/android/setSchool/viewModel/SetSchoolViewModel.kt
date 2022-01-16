package com.iamgonna.android.setSchool.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamgonna.android.`object`.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetSchoolViewModel : ViewModel() {
    val schoolData = MutableLiveData<String>()
    fun searchSchool(school : String) {
        val searchSchoolApi = RetrofitClient.instance.searchSchool
        CoroutineScope(Dispatchers.IO).launch {
            val response = searchSchoolApi.searchSchool(school)
            if (response.isSuccessful){
                schoolData.value = response.body()!!.address
            }
        }
    }
}