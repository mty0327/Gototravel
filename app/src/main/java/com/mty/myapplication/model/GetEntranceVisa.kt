package com.mty.myapplication.model

data class GetEntranceVisa(
    val currentCount: Int,
    val data: MutableList <GetEntranceVisaItem>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
)

data class GetEntranceVisaItem(
    val id:String,
    val country_eng_nm:String,
    val country_nm:String,
    val country_iso_alp2:String,
    val have_yn:String,
    val gnrl_pspt_visa_yn:String,
    val gnrl_pspt_visa_cn:String,
    val ofclpspt_visa_yn:String,
    val ofclpspt_visa_cn:String,
    val dplmt_pspt_visa_yn:String,
    val dplmt_pspt_visa_cn:String,
    val nvisa_entry_evdc_cn:String,
    val remark:String
)
