package com.mty.myapplication.model

data class Response(
    val currentCount: String="",
    val data: List<Datum>,
    val numOfRows: Int,
    val pageNo: Int,
    val resultCode: Int,
    val resultMsg: String="",
    val totalCount: Int
)
val response = Response(
    currentCount = "1",
    data = listOf(
        Datum(
            file_download_url = "",
            id = "ATC0000000007730",
            title = "중국 베이징 수도공항 국제선 노선 변경 보도 관련 공지",
            txt_origin_cn = "베이징 수도공항 국제선 노선 변경 보도 관련 공지○ 최근 중국 일부&nbsp;중국민용항공국이 베이징 수도공항을 이용 중인 일부 국제선 노선의 착륙 지점을 베이징 주변 공항으로 변경한다고 보도한 바 있습니다.&nbsp; ※ 3.17. 봉황신문(凤凰新闻) 보도 내용 요지- 3.17. 민항국은&nbsp;긴급 화상회의를 통해 베이징 입국 예정 항공편을 톈진(天津), 스자좡(石家庄), 타이위안(太原), 후허하오터시(呼和浩特)로 분산 착륙시켜 탑승객 대상으로 코로나19 검사를 실시한 후 유증상자에 대해서는 현지에서 치료를 받도록 하고, 무증상자에 대해서 다시 베이징으로 입국시킬 방침이라고 통지함. 이를 통해 베이징시 입국 항공편이 대폭 감소될 것으로 보임.○ 외교부는 주중대사관&nbsp;등을 통해 동 보도내용의 사실 관계를 지속 파악하여 추가 공지할 예정인바, 베이징 입국을 계획하고 계신 우리 국민들께서는 외교부‧주중대사관 공지 및 이용 항공사의 최신 정보 등을 수시로 확인해 주시기 바랍니다.&nbsp; 끝.&nbsp;",
            written_dt = "2020-08-26"
        )
    ),
    numOfRows = 10,
    pageNo = 1,
    resultCode = 0,
    resultMsg = "정상",
    totalCount = 225
)
