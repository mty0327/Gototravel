package com.mty.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import android.provider.DocumentsContract.Document
import android.util.Xml
import android.widget.Button
import android.widget.Toast
import com.google.gson.Gson
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivityResultBinding
import okhttp3.OkHttpClient
import org.xml.sax.SAXException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

class ResultActivity : AppCompatActivity() {

    val binding: ActivityResultBinding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var intent: Intent = getIntent()
        var nation: String = intent.getStringExtra("country") ?: "대한민국"

        Toast.makeText(this, "${nation}", Toast.LENGTH_SHORT).show()

        loadData(nation)
    }

    fun loadData(nation: String) {
        val address: String = "https://apis.data.go.kr/1262000/CountryBasicService/getCountryBasicList?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D&numOfRows=10&pageNo=1&countryName=%EA%B0%80%EB%82%98"

        try {
            val url:URL= URL(address)
            val isr:InputStream=url.openStream()
            val reader:InputStreamReader=InputStreamReader(isr)

            val parserFactory = XmlPullParserFactory.newInstance()
            val kXmlParser = parserFactory.newPullParser()
            kXmlParser.setInput(reader)



        } catch(e: Exception) {

        }





    }
}
