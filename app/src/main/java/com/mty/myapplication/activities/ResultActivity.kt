package com.mty.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mty.myapplication.G
import com.mty.myapplication.databinding.ActivityResultBinding
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

class ResultActivity : AppCompatActivity() {

    val binding: ActivityResultBinding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var nation: String = intent.getStringExtra("country") ?: "가나"
        G.nation=nation

        Toast.makeText(this, "${nation}", Toast.LENGTH_SHORT).show()

        loadData(nation)

        binding.btn1.setOnClickListener {
            val i1 = Intent(this, Result1Activity::class.java)
            startActivity(i1) //
        }


        binding.btn2.setOnClickListener {
            val i2 = Intent(this, Result2Activity::class.java)
            startActivity(i2)
        }

        binding.btn3.setOnClickListener {
            val i3 = Intent(this, Result2Activity::class.java)
            startActivity(i3)
        }


        binding.btn4.setOnClickListener {
            val i4 = Intent(this, Result2Activity::class.java)
            startActivity(i4)
        }


        binding.btn5.setOnClickListener {
            val i5 = Intent(this, Result2Activity::class.java)
            startActivity(i5)
        }


        binding.btn6.setOnClickListener {
            val i6 = Intent(this, Result2Activity::class.java)
            startActivity(i6)
        }


        binding.btn7.setOnClickListener {
            val i7 = Intent(this, Result2Activity::class.java)
            startActivity(i7)
        }


        binding.btn8.setOnClickListener {
            val i8 = Intent(this, Result2Activity::class.java)
            startActivity(i8)
        }


        binding.btn9.setOnClickListener {
            val i9 = Intent(this, Result2Activity::class.java)
            startActivity(i9)
        }
    }


    fun loadData(nation: String) {

        object : Thread() {
            override fun run() {

                val s = URLEncoder.encode(nation, "UTF-8")
                val address: String =
                    "https://apis.data.go.kr/1262000/CountryBasicService/getCountryBasicList?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D&numOfRows=10&pageNo=1&countryName=${s}"

                try {
                    val url: URL = URL(address)
                    val isr: InputStream = url.openStream()
                    val reader: InputStreamReader = InputStreamReader(isr)

                    //r1XML문서파싱객체 생성
                    val parserFactory = XmlPullParserFactory.newInstance()
                    val r1XmlParser = parserFactory.newPullParser()
                    r1XmlParser.setInput(reader)

                    //r1XmlParser에게 분석작업을 요청
                    var eventType = r1XmlParser.eventType //시작위치가 Start Document

                    while (eventType != XmlPullParser.END_DOCUMENT) {

                        when (eventType) {
                            XmlPullParser.START_DOCUMENT ->
                                runOnUiThread {
                                    Toast.makeText(
                                        this@ResultActivity,
                                        "파싱 시작!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            XmlPullParser.START_TAG -> {
                                val tagName = r1XmlParser.name //태그이름
                                if (tagName == "item") {
                                    G.countryBasicService = CountryBasicService()
                                } else if (tagName == "basic") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.basic = r1XmlParser.text
                                } else if (tagName == "continent") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.continent = r1XmlParser.text
                                } else if (tagName == "countryEnName") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.countryEnName = r1XmlParser.text
                                } else if (tagName == "countryName") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.contryName = r1XmlParser.text
                                } else if (tagName == "id") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.id = r1XmlParser.text
                                } else if (tagName == "imgUrl") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.imgUrl = r1XmlParser.text
                                } else if (tagName == "wrtDt") {
                                    r1XmlParser.next()
                                    G.countryBasicService?.wrtDt = r1XmlParser.text
                                }
                            }
                        }

                        eventType = r1XmlParser.next()

                    }//while문 끝나는곳

                    //분석이 끝났으니, 결과확인만

                    runOnUiThread {
                        Toast.makeText(
                            this@ResultActivity,
                            "${G.countryBasicService?.basic}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                } catch (e: Exception) {

                }

            }
        }.start()// 버튼1번 기본정보 끝


    }
}