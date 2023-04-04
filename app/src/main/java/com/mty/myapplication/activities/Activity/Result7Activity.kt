package com.mty.myapplication.activities.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.databinding.ActivityResult6Binding
import com.mty.myapplication.databinding.ActivityResult7Binding
import java.io.BufferedReader
import java.io.IOException
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
    object ApiExplorer {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val urlBuilder =
                StringBuilder("http://apis.data.go.kr/1262000/CountrySafetyService3/getCountrySafetyList3") /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D") /*Service Key*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "returnType",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("JSON", "UTF-8")
            ) /*XML 또는 JSON*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "numOfRows",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("10", "UTF-8")
            ) /*한 페이지 결과 수*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "cond[country_nm::EQ]",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("카자흐스탄", "UTF-8")
            ) /*한글 국가명*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "cond[country_iso_alp2::EQ]",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("KZ", "UTF-8")
            ) /*ISO 2자리코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(
                    "1",
                    "UTF-8"
                )
            ) /*페이지 번호*/
            val url = URL(urlBuilder.toString())
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-type", "application/json")
            println("Response code: " + conn.responseCode)
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