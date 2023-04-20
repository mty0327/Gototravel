package com.mty.myapplication.model

data class LocalContactService(
    val currentCount: Int,
    val data: List<Data>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String,
    val totalCount: Int
) {
    data class Data(
        val contact_remark: String, // 연락처 정보와 주재국 신고 정보, 의료기관 연락처 정보가 HTML 형식으로 포함됩니다.
        val continent_cd: String, // 대륙 코드
        val continent_eng_nm: String, // 대륙 영문 이름
        val continent_nm: String, // 대륙 이름
        val country_eng_nm: String, // 국가 영문 이름
        val country_iso_alp2: String, // 국가 ISO 알파벳 2자리 코드
        val country_nm: String, // 국가 이름
        val dang_map_download_url: String, // 다문화 지도 다운로드 URL
        val flag_download_url: String, // 국기 이미지 다운로드 URL
        val map_download_url: String, // 지도 이미지 다운로드 URL
        val wrt_dt: String // 데이터 작성 일자
    )
}
