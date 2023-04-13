package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.databinding.ActivityResult2Binding

class Result2Activity : AppCompatActivity() {

    val binding:ActivityResult2Binding by lazy { ActivityResult2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}