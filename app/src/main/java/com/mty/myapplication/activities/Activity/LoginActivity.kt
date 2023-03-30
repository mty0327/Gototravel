package com.mty.myapplication.activities.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.mty.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    val binding:ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //회원가입 누를 때
        binding.tvSignup.setOnClickListener{
            //회원가입창으로 화면 전환
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //이메일 로그인 버튼 누를 때
        binding.layoutEmail.setOnClickListener {
            //이메일 로그인 화면으로 전환
            startActivity(Intent(this, EmailSigninActivity::class.java))
        }

        //카카오,구글,네이버 로그인 기능들
        binding.ivLoginKakao.setOnClickListener { clickedLoginKakao() }
        binding.ivLoginGoogle.setOnClickListener { clickedLoginGoogle() }
        binding.ivLoginNaver.setOnClickListener { clickedLoginNaver() }
    }
    private fun clickedLoginKakao(){

    }

    private fun clickedLoginGoogle(){

    }

    private fun clickedLoginNaver(){

    }

}