package com.iamgonna.android.login.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamgonna.android.`object`.App
import com.iamgonna.android.login.model.LoginRequest
import com.iamgonna.android.`object`.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val io = Dispatchers.IO
    var loginResponse = MutableLiveData<Int>()
    fun login(email: String, pw: String) {
        val loginApi = RetrofitClient.instance.login
        CoroutineScope(io).launch {
            val response = loginApi.login(LoginRequest(email, pw))
            App.prefs.setString("Token",response.body()!!.token)
            loginResponse.value = response.code()
        }
    }
}