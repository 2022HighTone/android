package com.iamgonna.android.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamgonna.android.`object`.App
import com.iamgonna.android.`object`.network.RetrofitClient
import com.iamgonna.android.main.model.Store
import com.naver.maps.geometry.LatLng
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val io = Dispatchers.IO
    private val ui = Dispatchers.Main
    val defaultLocation = MutableLiveData<LatLng>()
    val storeLocation = MutableLiveData<Store>()
    fun getDefaultLocation() {
        val defaultLocationApi = RetrofitClient.instance.defaultLocation
        CoroutineScope(io).launch {
            defaultLocationApi.getLocation(App.prefs.getString("Token", "null")).apply {
                withContext(ui) {
                    defaultLocation.value = LatLng(body()!!.latitude, body()!!.longitude)
                    body()!!.stores.forEachIndexed { _, store ->
                        storeLocation.value = store
                    }
                }
            }
        }
    }
    fun findSchool(name : String) {
        val findSchoolApi = RetrofitClient.instance.defaultLocation
        CoroutineScope(io).launch {
            val response = findSchoolApi.searchSchool(name)
            if (response.isSuccessful){
                val result = findSchoolApi.resultSchool(response.body()!!.name, response.body()!!.address)
                withContext(ui){
                    defaultLocation.value = LatLng(result.body()!!.latitude, result.body()!!.longitude)
                }
            }
        }
    }
}