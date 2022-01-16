package com.iamgonna.android.login.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamgonna.android.`object`.App
import com.iamgonna.android.login.model.LoginRequest
import com.iamgonna.android.`object`.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    private val io = Dispatchers.IO
    private val ui = Dispatchers.Main
    var loginResponse = MutableLiveData<Int>()
    fun login(email: String, pw: String) {
        val loginApi = RetrofitClient.instance.login
        CoroutineScope(io).launch {
            val response = loginApi.login(LoginRequest(email, pw))
            if (response.isSuccessful){
                App.prefs.setString("Token",response.body()!!.token)
            }
            withContext(ui){
                loginResponse.value = response.code()
            }

        }
    }
}