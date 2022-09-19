package com.kjy.risingtest_todayhouse_teamb.src.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import com.kjy.risingtest_todayhouse_teamb.config.BaseActivity
import com.kjy.risingtest_todayhouse_teamb.databinding.ActivityLoginBinding
import com.kjy.risingtest_todayhouse_teamb.src.login.joinemail.EmailJoinActivity
import com.kjy.risingtest_todayhouse_teamb.src.login.loginemail.EmailLoginActivity
import com.kjy.risingtest_todayhouse_teamb.src.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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