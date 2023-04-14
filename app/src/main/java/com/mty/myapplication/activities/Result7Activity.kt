package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mty.myapplication.G
import com.mty.myapplication.databinding.ActivityResult7Binding
import com.mty.myapplication.model.CountryBasicService
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result7Activity : AppCompatActivity() {

    val binding: ActivityResult7Binding by lazy { ActivityResult7Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    fun loadData(nation: String) {

        object : Thread() {
            override fun run() {

                val s = URLEncoder.encode(nation, "UTF-8")
                val address: String =
                    "https://apis.data.go.kr/1262000/CountryNoticeService/getCountryNoticeList?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D&numOfRows=10&pageNo=1&isoCode1=${s}"

            }
        }
    }
}














