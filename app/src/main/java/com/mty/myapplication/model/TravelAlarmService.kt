package com.mty.myapplication.model

data class TravelAlarmService(
    val currentCount: Int,
    val data: MutableList <TravelAlarmItem>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)
data class TravelAlarmItem(
    val alarm_lvl: String,
    val continent_cd: String,
    val continent_eng_nm: String,
    val continent_nm: String,
    val country_eng_nm: String,
    val country_iso_alp2: String,
    val country_nm: String,
    val dang_map_download_url: String,
    val flag_download_url: String,
    val map_download_url: String,
    val region_ty: String,
    val remark: String,
    val written_dt: String
)
