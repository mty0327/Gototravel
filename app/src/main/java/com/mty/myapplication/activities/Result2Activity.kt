package com.mty.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mty.myapplication.SafetyNoticeResponse
import com.mty.myapplication.SafetyNoticeService
import com.mty.myapplication.databinding.ActivityResult2Binding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class Result2Activity : AppCompatActivity() {

    val binding: ActivityResult2Binding by lazy { ActivityResult2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        suspend fun main() {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/1262000/CountrySafetyService3/getCountrySafetyList3")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(SafetyNoticeService::class.java)
            val response = service.getSafetyNotices()

            // response를 사용하여 데이터 처리
            println(response.data.first().title)
        }
        binding.tvFrg2.text= SafetyListR
    }
}