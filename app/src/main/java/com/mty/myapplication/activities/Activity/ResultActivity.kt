package com.mty.myapplication.activities.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import android.widget.Button
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    val binding:ActivityResultBinding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        }

    }