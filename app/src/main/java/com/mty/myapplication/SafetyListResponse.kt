package com.mty.myapplication

data class SafetyNoticeResponse(
    val currentCount: Int,
    val data: List<SafetyNotice>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)

data class SafetyNotice(
    val continent_cd: String,
    val continent_eng_nm: String,
    val continent_nm: String,
    val country_eng_nm: String,
    val country_iso_alp2: String,
    val country_nm: String,
    val ctgy_nm: String,
    val file_download_url: String,
    val file_path: String?,
    val sfty_notice_id: String,
    val title: String,
    val txt_origin_cn: String,
    val wrt_dt: String
)