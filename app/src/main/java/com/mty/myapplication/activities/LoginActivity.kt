package com.mty.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.mty.myapplication.databinding.ActivityLoginBinding
import com.mty.myapplication.model.NidUserInfoResponse
import com.mty.myapplication.model.UserAccount
import com.mty.myapplication.network.A
import com.mty.myapplication.network.RetrofitApiService
import com.mty.myapplication.network.RetrofitHelper
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    val binding:ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //회원가입 누를 때
        binding.tvSignup.setOnClickListener{
            //회원가입창으로 화면 전환
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        //이메일 로그인 버튼 누를 때
        binding.layoutEmail.setOnClickListener {
            //이메일 로그인 화면으로 전환
            startActivity(Intent(this, EmailSigninActivity::class.java))
        }

        //카카오,구글,네이버 로그인 기능들
        binding.ivLoginKakao.setOnClickListener { clickedLoginKakao() }
        binding.ivLoginGoogle.setOnClickListener { clickedLoginGoogle() }
        binding.ivLoginNaver.setOnClickListener { clickedLoginNaver() }

        var keyHash = Utility.getKeyHash(this)
        Log.i("mty",keyHash)
    }
    private fun clickedLoginKakao(){
        val callback:(OAuthToken?, Throwable?)->Unit= { token, error ->
            if(token!=null){
                Toast.makeText(this, "카카오 로그인 성공", Toast.LENGTH_SHORT).show()

                //사용자 정보 요청 [ 1.회원번호, 2.이메일주소 ]
                UserApiClient.instance.me { user, error ->
                    if(user!=null){
                        var id:String= user.id.toString()
                        var email:String= user.kakaoAccount?.email ?: ""  //혹시 null이면 이메일의 기본값은 ""

                        Toast.makeText(this, "$email", Toast.LENGTH_SHORT).show()
                        A.userAccount= UserAccount(id, email)

                        // main 화면으로 이동
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }

            }else{
                Toast.makeText(this, "카카오 로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        //카카오톡이 설치되어 있으면 카톡으로 로그인, 아니면 카카오계정 로그인
        if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
            UserApiClient.instance.loginWithKakaoTalk(this,callback = callback)
        }else{
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

    private fun clickedLoginGoogle(){
        // Google에서 검색 [ 안드로이드 구글 로그인 ]

        // 구글 로그인 옵션객체 생성 - Builder 이용
        val signInOptions: GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()


        // 구글 로그인 화면(액티비티)을 실행하는 Intent를 통해 로그인 구현
        val intent:Intent= GoogleSignIn.getClient(this, signInOptions).signInIntent
        resultLauncher.launch(intent)
    }

    //구글 로그인 화면(액티비티)의 실행결과를 받아오는 대행사
    val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(), object :
            ActivityResultCallback<ActivityResult> {
        override fun onActivityResult(result: ActivityResult?) {
            //로그인 결과를 가져온 인텐트객체 소환
            val intent:Intent?= result?.data

            //돌아온 Intent로부터 구글 계정 정보를 가져오는 작업 수행
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(intent)

            val accout: GoogleSignInAccount = task.result
            var id:String= accout.id.toString()
            var email:String= accout.email ?: ""

            Toast.makeText(this@LoginActivity, "$email", Toast.LENGTH_SHORT).show()
            A.userAccount= UserAccount(id, email)

            //main 화면으로 이동
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    })

    private fun clickedLoginNaver(){
        // 네아로 초기화
        NaverIdLoginSDK.initialize(this, "1_5ZR_FS_yPTvgsvaAEO", "K2NKF4yvyE", "회원")

        // 네이버 로그인
        NaverIdLoginSDK.authenticate(this, object : OAuthLoginCallback {
            override fun onError(errorCode: Int, message: String) {
                Toast.makeText(this@LoginActivity, "error : $message", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(httpStatus: Int, message: String) {
                Toast.makeText(this@LoginActivity, "로그인 실패 : $message", Toast.LENGTH_SHORT).show()
            }

            override fun onSuccess() {
                Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()

                // 사용자 정보를 가져오는 REST API를 작업할때 접속토큰이 필요함.
                val accessToken:String? = NaverIdLoginSDK.getAccessToken()
                // 토큰값 확인
                Log.i("token", accessToken!!)

                // 레트로핏으로 사용자정보 API 가져오기
                val retrofit= RetrofitHelper.getRetrofitInstance("https://openapi.naver.com")
                retrofit.create(RetrofitApiService::class.java).getNidUserInfo("Bearer $accessToken").enqueue(object :
                    Callback<NidUserInfoResponse> {
                    override fun onResponse(
                        call: Call<NidUserInfoResponse>,
                        response: Response<NidUserInfoResponse>
                    ) {
                        val userInfoResponse: NidUserInfoResponse?= response.body()
                        val id:String= userInfoResponse?.response?.id ?: ""
                        val email:String= userInfoResponse?.response?.email ?: ""

                        Toast.makeText(this@LoginActivity, "$email", Toast.LENGTH_SHORT).show()
                        A.userAccount= UserAccount(id, email)

                        // main 화면으로 이동
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }

                    override fun onFailure(call: Call<NidUserInfoResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "회원정보 불러오기 실패 : ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })

            }
        })

    }

}