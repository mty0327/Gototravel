package com.mty.myapplication.model

data class NationNoticeService(
    val currentCount: Int,
    val `data`: List<Data>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)