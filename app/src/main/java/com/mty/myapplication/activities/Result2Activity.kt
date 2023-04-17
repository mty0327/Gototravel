package com.mty.myapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mty.myapplication.G
import com.mty.myapplication.SafetyNotice
import com.mty.myapplication.SafetyNoticeItem
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.databinding.ActivityResult2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class Result2Activity : AppCompatActivity() {


    val binding: ActivityResult2Binding by lazy { ActivityResult2Binding.inflate(layoutInflater) }
    var items:MutableList<SafetyNoticeItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://apis.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SafetyNoticeService::class.java)
        service.getSafetyNotices( G.nation).enqueue(object:Callback<SafetyNotice>{
            override fun onResponse(call: Call<SafetyNotice>, response: Response<SafetyNotice>) {

                val safetyNotice= response.body()

                items= safetyNotice!!.data
                Toast.makeText(this@Result2Activity, " ${items[0].title}", Toast.LENGTH_SHORT).show()

                //recyclerView를 이용하여 items 보여주기
            }

            override fun onFailure(call: Call<SafetyNotice>, t: Throwable) {
                Toast.makeText(this@Result2Activity, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }
}