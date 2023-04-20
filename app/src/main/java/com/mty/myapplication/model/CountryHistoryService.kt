package com.mty.myapplication.model

data class CountryHistoryService(
    val currentCount: Int,
    val data: MutableList <CountryHistoryItem>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)
data class CountryHistoryItem(
    val title:String,
    val txt_origin_cn:String,
    val wrt_dt:String,
    val file_download_url:String
)
