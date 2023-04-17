package com.mty.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SafetyNoticeService {
    @GET("1262000/CountrySafetyService3/getCountrySafetyList3?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getSafetyNotices(@Query("cond[country_nm::EQ]") nation: String): Call<SafetyNotice>
}