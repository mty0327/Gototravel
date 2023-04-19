package com.mty.myapplication.model

data class SpTravelWarning(
    val currentCount: Int,
    val data: MutableList<SpTravelWarningitem>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)

data class SpTravelWarningitem(
    val continent_cd:String,
    val continent_eng_nm:String,
    val continent_nm:String,
    val country_eng_nm:String,
    val country_iso_alp2:String,
    val country_nm:String,
    val dang_map_download_url:String,
    val evacuate_rcmnd_remark:String,
    val flag_download_url:String,
    val map_download_url:String,
    val region_ty:String,
    val written_dt:String
)