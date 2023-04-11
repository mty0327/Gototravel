package com.mty.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import android.widget.Button
import android.widget.Toast
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivityResultBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class ResultActivity : AppCompatActivity() {

    val binding:ActivityResultBinding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var intent: Intent = getIntent()
        var nation: String? = intent.getStringExtra("country")

        Toast.makeText(this, "${nation}", Toast.LENGTH_SHORT).show()

    }
}