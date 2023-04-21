package com.mty.myapplication.model

data class SafetyNews(
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val data: MutableList<SafetyNewsItem>,
    val resultCode: Int,
    val resultMsg: String,
)
data class SafetyNewsItem(
    val id: String,
    val countryName: String,
    val countryEnName: String,
    val title: String,
    val content: String,
    val contentHtml: String,
    val fileUrl: String?,
    val wrtDt: String,
)
