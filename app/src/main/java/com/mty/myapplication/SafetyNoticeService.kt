package com.mty.myapplication

import com.mty.myapplication.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SafetyNoticeService {

    @GET("1262000/EntranceVisaService2/getEntranceVisaList2?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getEntranceVisas(@Query("cond[country_nm::EQ]") nation: String):Call<GetEntranceVisa>
    @GET("1262000/CountrySafetyService3/getCountrySafetyList3?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getSafetyNotices(@Query("cond[country_nm::EQ]") nation: String): Call<SafetyNotice>

    @GET("1262000/SptravelWarningService2/getSptravelWarningList2?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getSptravelWariningServices(@Query("cond[country_nm::EQ]")nation: String): Call<SpTravelWarning>

    @GET("1262000/TravelAlarmService2/getTravelAlarmList2?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getTravelAlarmServices(@Query("cond[country_nm::EQ]")nation: String): Call<TravelAlarmService>

    @GET("1262000/CountryHistoryService2/getCountryHistoryList2?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getCountryHistoryServices(@Query("cond[country_nm::EQ]")nation: String): Call<CountryHistoryService>

    @GET("1262000/LocalContactService2/getLocalContactList2?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getLocalContactServices(@Query("cond[country_nm::EQ]")nation: String): Call<LocalContactService>

    @GET("1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew?serviceKey=I9VYqPF7Jlua0khI%2B7%2FP0dEpDY4BH2tthlOu9A88wMrXWnboJl2IdpjGJPV13ot0Wi8yyUCD9jBRkZynRj4mOA%3D%3D")
    fun getSafetyNewsLists(@Query("nation")nation: String): Call<SafetyNews>

}