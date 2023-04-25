package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.adapters.LocalContactServiceAdapter
import com.mty.myapplication.databinding.ActivityResult8Binding
import com.mty.myapplication.model.LocalContactService
import com.mty.myapplication.model.LocalContactitem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result8Activity : AppCompatActivity() {

    val binding: ActivityResult8Binding by lazy { ActivityResult8Binding.inflate(layoutInflater) }
    var items: MutableList<LocalContactitem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getLocalContactServices(G.nation).enqueue(object : Callback<LocalContactService> {
            override fun onResponse(call: Call<LocalContactService>, response: Response<LocalContactService>) {

                val LocalContactService =response.body()

                items= LocalContactService!!.data as MutableList<LocalContactitem>



                //recyclerview이용
                binding.re8.adapter= LocalContactServiceAdapter(items)
                binding.re8.layoutManager = LinearLayoutManager(this@Result8Activity)
                binding.re8.setHasFixedSize(true)

            }

            override fun onFailure(call: Call<LocalContactService>, t: Throwable) {
                Toast.makeText(this@Result8Activity, "Error", Toast.LENGTH_SHORT).show()
                Log.i("tag",t.message.toString())
            }

        })
    }
}