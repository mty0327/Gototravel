package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.adapters.CountryHistoryServiceAdapter
import com.mty.myapplication.databinding.ActivityResult6Binding
import com.mty.myapplication.model.CountryHistoryItem
import com.mty.myapplication.model.CountryHistoryService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Result6Activity : AppCompatActivity() {

    val binding: ActivityResult6Binding by lazy { ActivityResult6Binding.inflate(layoutInflater) }
    var items: MutableList<CountryHistoryItem> = mutableListOf() // 변경된 부분
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getCountryHistoryServices(G.nation).enqueue(object :Callback<CountryHistoryService> {
            override fun onResponse(call: Call<CountryHistoryService>, response: Response<CountryHistoryService>) {

                val countryHistoryService = response.body()

                items = countryHistoryService!!.data // 변경된 부분


                //recyclerView이용하기
                binding.re6.adapter= CountryHistoryServiceAdapter(items)
                binding.re6.layoutManager = LinearLayoutManager(this@Result6Activity)
                binding.re6.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<CountryHistoryService>, t: Throwable) {
                Toast.makeText(this@Result6Activity, "Error", Toast.LENGTH_SHORT).show()
                Log.i("tag", t.message.toString())
            }
        })
    }
}
