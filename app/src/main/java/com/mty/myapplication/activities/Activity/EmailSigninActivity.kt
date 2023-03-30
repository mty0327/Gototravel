package com.mty.myapplication.activities.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivityEmailSigninBinding

class EmailSigninActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmailSigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailSigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_arrow_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.btnSignin.setOnClickListener { clickSignIn() }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun clickSignIn() {

        var email: String = binding.etEmail.text.toString()
        var password: String = binding.etPassword.text.toString()


    }
}