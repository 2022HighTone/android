package com.iamgonna.android.signUp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iamgonna.android.databinding.ActivitySignUpBinding
import com.iamgonna.android.login.view.LoginActivity
import com.iamgonna.android.signUp.viewModel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignUpBinding.inflate(layoutInflater) }
    private val viewModel = SignUpViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.signUpResponse.observe(this,{
            if (it == 200){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"$it 회원가입에 실패했습니다", Toast.LENGTH_SHORT).show()
            }
        })

    }
}