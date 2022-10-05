package com.kjy.risingtest_todayhouse_teamb.src.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Toast
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityLoginBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.EmailJoinActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.EmailLoginActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 카카오 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo{ tokenInfo, error ->
            if (error != null) {
                showCustomToast("토큰 정보 보기 실패")
            }else if(tokenInfo != null) {
                showCustomToast("토큰 정보 보기 성공")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }


        // 각종 콜백으로 오류에 대응함
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        showCustomToast("접근이 거부됨(동의 취소)")
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        showCustomToast("유효하지 않은 앱")
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        showCustomToast("인증 수단이 유효하지 않아 인증할 수 없는 상태")
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        showCustomToast("요청 파라미터 오류")
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        showCustomToast("유효하지 않은 scope ID")
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        showCustomToast("설정이 올바르지 않음(android key hash)")
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        showCustomToast("서버 내부 에러")
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        showCustomToast("앱이 요청 권한이 없음")
                    }
                    else -> { // Unknown
                        showCustomToast("기타 에러")
                    }
                }
            } else if (token != null) {
                showCustomToast("로그인에 성공하였습니다.")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        // 카카오 로그인 버튼 클릭시 로그인 여부 판단
        binding.loginBtnKakao.setOnClickListener {
            if(LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
            }else {
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }

        // 로그인 액티비티의 특정 글씨 굵게하는 커스텀 적용
        loginTextCustom()

        // 이메일로 로그인
        loginEmail()

        // 이메일로 가입하기
        joinEmail()

        binding.loginBtnNaver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    // 로그인 액티비티의 "최대 10만원" 글씨의 굵기를 적용함
    private fun loginTextCustom() {
        // 텍스트 데이터 변수 얻음
        val loginText = binding.loginTvMain1

        // 변환해주는 Builder 생성
        val builder = SpannableStringBuilder("지금 가입하면 최대 10만원")

        val boldSpan = StyleSpan(Typeface.BOLD)
        builder.setSpan(boldSpan, 8, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        loginText.text = builder
    }

    // 이메일로 로그인 클릭시 해당 액티비티로 이동
    private fun loginEmail() {
        binding.loginBtnEmailLogin.setOnClickListener {
            val intent = Intent(this, EmailLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun joinEmail() {
        binding.loginBtnEmailJoin.setOnClickListener {
            val intent = Intent(this, EmailJoinActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}