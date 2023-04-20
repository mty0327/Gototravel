package com.mty.myapplication.model

data class SafetyNewsList(
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val Id: String,
    val countryName: String,
    val countryEnName: String,
    val title: String,
    val content:String,
    val contentHtml:String,
    val fileUrl:String="",
    val wrtDt:String,
    val resultCode: Int,
    val resultMsg:String
)
