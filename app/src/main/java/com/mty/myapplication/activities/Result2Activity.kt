package com.mty.myapplication.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mty.myapplication.G
import com.mty.myapplication.G.Companion.nation
import com.mty.myapplication.databinding.ActivityResult2Binding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class Result2Activity : AppCompatActivity() {

    val binding: ActivityResult2Binding by lazy { ActivityResult2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()
    }

    fun loadData() {
        Toast.makeText(this, "${G.nation}", Toast.LENGTH_SHORT).show()

        fun main() {
            val urlBuilder = StringBuilder("http://apis.data.go.kr/1262000/CountrySafetyService3/getCountrySafetyList3")
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키")
            urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"))
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"))
            urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]", "UTF-8") + "=" + URLEncoder.encode("카자흐스탄", "UTF-8"))
            urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]", "UTF-8") + "=" + URLEncoder.encode("KZ", "UTF-8"))
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"))
            val url = URL(urlBuilder.toString())
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-type", "application/json")
            println("Response code: ${conn.responseCode}")
            val rd: BufferedReader
            rd = if (conn.responseCode >= 200 && conn.responseCode <= 300) {
                BufferedReader(InputStreamReader(conn.inputStream))
            } else {
                BufferedReader(InputStreamReader(conn.errorStream))
            }
            val sb = StringBuilder()
            var line: String?
            while (rd.readLine().also { line = it } != null) {
                sb.append(line)
            }
            rd.close()
            conn.disconnect()
            println(sb.toString())
        }
    }
}