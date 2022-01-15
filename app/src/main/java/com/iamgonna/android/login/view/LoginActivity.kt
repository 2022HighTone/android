package com.iamgonna.android.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iamgonna.android.MainActivity
import com.iamgonna.android.databinding.ActivityLoginBinding
import com.iamgonna.android.login.viewModel.LoginViewModel
import com.iamgonna.android.signUp.view.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.run {
            btnLogin.setOnClickListener {
                viewModel.login(etInputEmail.text.toString(), etInputPw.text.toString())
            }
            btnSignUp.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
        viewModel.loginResponse.observe(this, {
            if (it == 200) {
                Toast.makeText(this, "로그인 성공!",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "$it 로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
            }
        })
    }
}