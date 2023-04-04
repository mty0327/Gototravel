package com.mty.myapplication.activities.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.databinding.ActivityResult1Binding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result1Activity : AppCompatActivity() {

    val binding:ActivityResult1Binding by lazy {ActivityResult1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    object ApiExplorer {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val urlBuilder =
                StringBuilder("http://apis.data.go.kr/1262000/CountryBasicService/getCountryBasicList") /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D") /*Service Key*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "numOfRows",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("10", "UTF-8")
            ) /*한페이지의 결과*/
            urlBuilder.append(
                "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(
                    "1",
                    "UTF-8"
                )
            ) /*페이지번호*/
            urlBuilder.append(
                "&" + URLEncoder.encode("countryName", "UTF-8") + "=" + URLEncoder.encode(
                    "가나",
                    "UTF-8"
                )
            ) /*한글국가명*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "countryEnName",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("Ghana", "UTF-8")
            ) /*영문국가명*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "isoCode1",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("GHA", "UTF-8")
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode2", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode3", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode4", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode5", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode6", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode7", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode8", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode("isoCode9", "UTF-8") + "=" + URLEncoder.encode(
                    "",
                    "UTF-8"
                )
            ) /*ISO국가코드*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "isoCode10",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("", "UTF-8")
            ) /*ISO국가코드*/
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