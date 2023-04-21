package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.adapters.SafetyNewsAdapter
import com.mty.myapplication.databinding.ActivityResult9Binding
import com.mty.myapplication.model.SafetyNews
import com.mty.myapplication.model.SafetyNewsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Result9Activity : AppCompatActivity() {

    val binding : ActivityResult9Binding by lazy { ActivityResult9Binding.inflate(layoutInflater) }
    var items : MutableList<SafetyNewsItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(SafetyNoticeService::class.java)
        service.getSafetyNewsLists(G.nation).enqueue(object :Callback<SafetyNews>{
            override fun onResponse(call: Call<SafetyNews>, response: Response<SafetyNews>) {

                val SafetyNewsService=response.body()

                items=SafetyNewsService!!.data
                //recyclerview 이용
                binding.re9.adapter = SafetyNewsAdapter(items)
                binding.re9.layoutManager= LinearLayoutManager(this@Result9Activity)
                binding.re9.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<SafetyNews>, t: Throwable) {
                Toast.makeText(this@Result9Activity, "Error", Toast.LENGTH_SHORT).show()
                Log.i("tag",t.message.toString())
            }

        })

    }
}