package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.databinding.ActivityResult5Binding
import com.mty.myapplication.databinding.ActivityResult6Binding
import com.mty.myapplication.model.SpTravelWarning
import com.mty.myapplication.model.TravelAlarmItem
import com.mty.myapplication.model.TravelAlarmService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result5Activity : AppCompatActivity() {

    val binding: ActivityResult5Binding by lazy { ActivityResult5Binding.inflate(layoutInflater) }
    val items:MutableList<TravelAlarmItem>= mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getTravelAlarmServices(G.nation).enqueue(object : Callback<SpTravelWarning>{
            override fun onResponse(
                call: Call<TravelAlarmService>,
                response: Response<TravelAlarmService>
            })
        {
            val TravelAlarmService = response.body()
            items=Safety
        }
}