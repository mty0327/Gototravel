package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mty.myapplication.databinding.ActivityResult3Binding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class Result3Activity : AppCompatActivity() {

    val binding: ActivityResult3Binding by lazy { ActivityResult3Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    object ApiExplorer {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val urlBuilder =
                StringBuilder("http://apis.data.go.kr/1262000/EntranceVisaService2/getEntranceVisaList2") /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=서비스키") /*Service Key*/
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
                "&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(
                    "1",
                    "UTF-8"
                )
            ) /*페이지 번호*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "cond[country_nm::EQ]",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("가나", "UTF-8")
            ) /*한글 국가명*/
            urlBuilder.append(
                "&" + URLEncoder.encode(
                    "cond[country_iso_alp2::EQ]",
                    "UTF-8"
                ) + "=" + URLEncoder.encode("GH", "UTF-8")
            ) /*ISO 2자리코드*/
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