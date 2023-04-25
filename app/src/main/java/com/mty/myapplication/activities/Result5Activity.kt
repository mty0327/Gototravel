package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.adapters.TravelAlarmServiceAdapter
import com.mty.myapplication.databinding.ActivityResult5Binding
import com.mty.myapplication.model.TravelAlarmItem
import com.mty.myapplication.model.TravelAlarmService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class Result5Activity : AppCompatActivity() {

    val binding: ActivityResult5Binding by lazy { ActivityResult5Binding.inflate(layoutInflater) }
    var items:MutableList<TravelAlarmItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getTravelAlarmServices(G.nation).enqueue(object :Callback<TravelAlarmService>{
            override fun onResponse(call: Call<TravelAlarmService>, response: Response<TravelAlarmService>) {

                val TravelAlarmService = response.body()

                items=TravelAlarmService!!.data

                //recyclerview이용하기
                binding.re5.adapter = TravelAlarmServiceAdapter(items)
                binding.re5.layoutManager = LinearLayoutManager(this@Result5Activity)
                binding.re5.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<TravelAlarmService>, t: Throwable) {
                Toast.makeText(this@Result5Activity, "Error", Toast.LENGTH_SHORT).show()
                Log.i("tag",t.message.toString())
            }
        })
    }
}