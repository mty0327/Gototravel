package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.adapters.SpTravelWarningServiceAdapter
import com.mty.myapplication.databinding.ActivityResult4Binding
import com.mty.myapplication.model.SpTravelWarning
import com.mty.myapplication.model.SpTravelWarningitem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Result4Activity : AppCompatActivity() {

    val binding: ActivityResult4Binding by lazy { ActivityResult4Binding.inflate(layoutInflater) }
    var items:MutableList<SpTravelWarningitem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getSptravelWariningServices(G.nation).enqueue(object :Callback<SpTravelWarning> {
                override fun onResponse(call: Call<SpTravelWarning>, response: Response<SpTravelWarning>) {

                    val SpTravelWarning = response.body()

                    items=SpTravelWarning!!.data

                    //recyclerview이용하기
                    binding.re4.adapter = SpTravelWarningServiceAdapter(items)
                    binding.re4.layoutManager = LinearLayoutManager(this@Result4Activity)
                    binding.re4.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<SpTravelWarning>, t: Throwable) {
                    Toast.makeText(this@Result4Activity, "Error", Toast.LENGTH_SHORT).show()
                    Log.i("tag",t.message.toString())
                }
        })
    }
}