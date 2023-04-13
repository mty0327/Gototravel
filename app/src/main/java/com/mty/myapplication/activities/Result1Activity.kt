package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.G
import com.mty.myapplication.databinding.ActivityResult1Binding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result1Activity : AppCompatActivity() {

    val binding:ActivityResult1Binding by lazy {ActivityResult1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvFrg1.text= G.countryBasicService?.basic
    }

}