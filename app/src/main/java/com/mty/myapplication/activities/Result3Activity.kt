package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mty.myapplication.EntranceVisaService
import com.mty.myapplication.G
import com.mty.myapplication.R
import com.mty.myapplication.adapters.GetEntranceVisaAdapter
import com.mty.myapplication.databinding.ActivityResult3Binding
import com.mty.myapplication.model.GetEntranceVisa
import com.mty.myapplication.model.GetEntranceVisaItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result3Activity : AppCompatActivity() {

    val binding:ActivityResult3Binding by lazy {ActivityResult3Binding.inflate(layoutInflater)}
    var items:MutableList<GetEntranceVisaItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(EntranceVisaService::class.java)
        service.getEntranceVisas(G.nation).enqueue(object :Callback<GetEntranceVisa>{
            override fun onResponse(
                call: Call<GetEntranceVisa>, response: Response<GetEntranceVisa>) {

                val getEntranceVisa=response.body()

                items=getEntranceVisa!!.data

                Toast.makeText(this@Result3Activity, " ${items[0].country_nm}", Toast.LENGTH_SHORT).show()

                //recyclerview이용하기

                binding.re3.adapter = GetEntranceVisaAdapter(items)
                binding.re3.layoutManager=LinearLayoutManager(this@Result3Activity)
                binding.re3.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<GetEntranceVisa>, t: Throwable) {
                Toast.makeText(this@Result3Activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}