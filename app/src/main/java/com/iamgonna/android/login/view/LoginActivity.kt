package com.iamgonna.android.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iamgonna.android.`object`.App
import com.iamgonna.android.main.view.MainActivity
import com.iamgonna.android.databinding.ActivityLoginBinding
import com.iamgonna.android.login.viewModel.LoginViewModel
import com.iamgonna.android.setSchool.view.SetSchoolActivity
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
                Log.d("example",App.prefs.getLogin("0", "login"))
                if (App.prefs.getLogin("0", "login") == "login"){
                    Toast.makeText(this, "로그인 성공!",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    App.prefs.putLogin("0","login")
                    val intent = Intent(this, SetSchoolActivity::class.java)
                    startActivity(intent)
                }

            } else {
                Toast.makeText(this, "$it 로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
            }
        })
    }
}