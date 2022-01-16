package com.iamgonna.android.signUp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iamgonna.android.`object`.network.RetrofitClient
import com.iamgonna.android.signUp.model.SignUpRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel : ViewModel() {
    private val io = Dispatchers.IO
    private val ui = Dispatchers.Main
    val signUpResponse = MutableLiveData<Int>()
    fun signUp(username : String, email : String, pw:String){
        val signUpApi = RetrofitClient.instance.signUp
        CoroutineScope(io).launch {
            val response = signUpApi.signUp(SignUpRequest(username, email, pw))
            withContext(ui){
                signUpResponse.value = response.code()
            }
        }
    }
}