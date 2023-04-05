package com.mty.myapplication.activities.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.MultiAutoCompleteTextView
import com.mty.myapplication.R
import com.mty.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 자동완성 국가이름 종류
        var items = arrayOf("가나", "가봉", "가이아나", "감비아", "건지 섬", "과들루프", "과테말라", "괌", "그레나다", "그리스",
            "그린란드", "기니", "기니비사우", "나미비아", "나우루", "나이지리아", "남극", "남수단", "남아프리카 공화국",
            "네덜란드", "네덜란드령안틸레스", "네팔", "노르웨이", "노퍽 섬", "누벨칼레도니", "뉴질랜드", "니우에", "니제르",
            "니카라과", "대한민국", "덴마크", "도미니카 공화국", "도미니카 연방", "독일", "동티모르", "라오스",
            "라이베리아", "라트비아", "러시아", "레바논", "레소토", "레위니옹", "루마니아", "룩셈부르크", "르완다",
            "리비아", "리투아니아", "리히텐슈타인", "마다가스카르", "마르티니크", "마셜 제도", "마요트", "마카오",
            "마케도니아 공화국", "말라위", "말레이시아", "말리", "맨 섬", "멕시코", "모나코", "모로코", "모리셔스",
            "모리타니", "모잠비크", "몬테네그로", "몬트세랫", "몰도바", "몰디브", "몰타", "몽골", "미국", "미국령 군소 제도",
            "미국령 버진아일랜드", "미얀마", "미크로네시아 연방", "바누아투", "바레인", "바베이도스", "바티칸 시국", "바하마",
            "방글라데시", "버뮤다", "베냉", "베네수엘라", "베트남", "벨기에", "벨라루스", "벨리즈", "보스니아 헤르체고비나",
            "보츠와나", "볼리비아", "부룬디", "부르키나파소", "부베 섬", "부탄", "북마리아나 제도", "불가리아", "브라질",
            "브루나이", "사모아", "사우디아라비아", "사우스조지아사우스샌드위치 제도", "산마리노", "상투메프린시페",
            "생피에르미클롱", "서사하라", "세네갈", "세르비아", "세이셸", "세인트루시아", "세인트빈센트그레나딘",
            "세인트키츠네비스", "세인트헬레나", "소말리아", "솔로몬 제도", "수단", "수리남", "스리랑카", "스발바르얀마옌",
            "스와질란드", "스웨덴", "스위스", "스페인", "슬로바키아", "슬로베니아", "시리아", "시에라리온", "싱가포르",
            "아랍에미리트", "아루바", "아르메니아", "아르헨티나", "아메리칸사모아", "아이슬란드", "아이티", "아일랜드",
            "아제르바이잔", "아프가니스탄", "안도라", "알바니아", "알제리", "앙골라", "앤티가바부다", "앵귈라", "에리트레아",
            "에스토니아", "에콰도르", "에티오피아", "엘살바도르", "영국", "영국령 버진아일랜드", "영국령 인도양 지역", "예멘",
            "오만", "오스트레일리아", "오스트리아", "온두라스", "올란드 제도", "왈리스퓌튀나", "요르단", "우간다",
            "우루과이", "우즈베키스탄", "우크라이나", "이라크", "이란", "이스라엘", "이집트", "이탈리아", "인도",
            "인도네시아", "일본", "자메이카", "잠비아", "저지 섬", "적도 기니", "조선민주주의인민공화국", "조지아",
            "중앙아프리카 공화국", "중화민국", "중화인민공화국", "지부티", "지브롤터", "짐바브웨", "차드", "체코", "칠레",
            "카메룬", "카보베르데", "카자흐스탄", "카타르", "캄보디아", "캐나다", "케냐", "케이맨 제도", "코모로", "코스타리카", "코코스 제도", "코트디부아르", "콜롬비아",
            "콩고 공화국", "콩고 민주 공화국", "쿠바", "쿠웨이트", "쿡 제도", "크로아티아", "크리스마스 섬", "키르기스스탄", "키리바시", "키프로스", "타이", "타지키스탄", "탄자니아", "터크스케이커스 제도",
            "터키", "토고", "토켈라우", "통가", "투르크메니스탄", "투발루", "튀니지", "트리니다드토바고", "파나마", "파라과이",
            "파키스탄", "파푸아 뉴기니", "팔라우", "팔레스타인", "페로 제도", "페루", "포르투갈", "포클랜드 제도", "폴란드",
            "푸에르토리코", "프랑스", "프랑스령 기아나", "프랑스령 남부와 남극 지역", "프랑스령 폴리네시아", "피지", "핀란드",
            "필리핀", "핏케언 제도", "허드맥도널드 제도", "헝가리", "홍콩",)
        var auto=findViewById<AutoCompleteTextView>(R.id.auto_re) // 어뎁터뷰 개체화
        var adapter= ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, items) //어뎁터 생성
        auto.setAdapter(adapter)    //어뎁터를 어뎁터뷰에 연결

        findViewById<Button>(R.id.btn_search).setOnClickListener {

            var auto_re : AutoCompleteTextView = findViewById(R.id.auto_re)
            var nation : String = auto_re.text.toString()

            var intent : Intent =  Intent(this,ResultActivity::class.java)
            intent.putExtra("country", nation)

            startActivity(intent)
        }

    }
}